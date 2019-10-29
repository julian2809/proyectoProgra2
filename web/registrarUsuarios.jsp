<%-- 
    Document   : registrarUsuarios
    Created on : 28/10/2019, 09:22:13 PM
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Usuarios</title>
    </head>
    <body>
        <form action="RegistroUsuarioServlet" method="post">
            <p>USUARIO: <input type="text" name="user"></input></p>
            <p>CONTRASE&ntilde;A <input type="password" name="pass"></input></p>
            <input type="submit" value="Guardar" name="botonGuardar"></input>
            <input type="submit" value="Regresar" name="botonRegresarMenu"></input>
        </form>
    </body>
</html>
