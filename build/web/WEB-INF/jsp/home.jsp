<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <title>Prueba Spring</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                                <h1>Ejemplo de Spring</h1>
                                <p>
                    <a href="<c:url value="add.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Identificación</th>
                        <th>Correo</th>
                        <th>Telefono</th>
                        <th>Acciones</th>
                    </tr>
                 </thead>
                <tbody>
                    <c:forEach items="${datos}" var="dato">
                        <tr>
                            <td><c:out value="${dato.id}"/></td>
                            <td><c:out value="${dato.nombre}"/></td>
                            <td><c:out value="${dato.identificacion}"/></td>
                            <td><c:out value="${dato.correo}"/></td>
                            <td><c:out value="${dato.telefono}"/></td>
                            <td>
                            <a href="<c:url value="edit.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                            <a href="<c:url value="delete.htm?id=${dato.id}"/>" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                            </td>

                        </tr>
                    </c:forEach>
                </tbody>              
            </table>
                </div>
        </div>
        
    </body>
</html>
