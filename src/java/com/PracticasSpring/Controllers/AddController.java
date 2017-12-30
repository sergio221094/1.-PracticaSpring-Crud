
package com.PracticasSpring.Controllers;

import com.PracticaSpring.Models.Conectar;
import com.PracticaSpring.Models.Usuarios;
import com.PracticaSpring.Models.UsuariosValidaciones;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("add.htm")
public class AddController {
    UsuariosValidaciones usuariosValidar;
    private final JdbcTemplate jdbcTemplate;
    
    public AddController() 
    {
        this.usuariosValidar=new UsuariosValidaciones();
        Conectar con=new Conectar();
        this.jdbcTemplate=new JdbcTemplate(con.conectar() );
    }
    @RequestMapping(method=RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("add");
        mav.addObject("usuarios",new Usuarios());
        return mav;
    }
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("usuarios") Usuarios u,
                BindingResult result,
                SessionStatus status
        )
    {
        this.usuariosValidar.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView mav=new ModelAndView();
            mav.setViewName("add");
            mav.addObject("usuarios",new Usuarios());
            return mav;
        }else
        {
        this.jdbcTemplate.update
        (
        "insert into usuarios (nombre,identificacion,correo,telefono) values (?,?,?,?)",
         u.getNombre(),u.getIdentificacion(),u.getCorreo(),u.getTelefono()
        );
         return new ModelAndView("redirect:/home.htm");
        }
       
    }
}
