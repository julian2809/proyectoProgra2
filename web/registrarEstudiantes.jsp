<%-- 
    Document   : registrarEstudiantes
    Created on : 28/10/2019, 09:25:37 PM
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
        <form action="RegistroEstudianteServlet" method="post">
            <p>CARNET: <input type="number" name="carnet"></input></p>
            <p>NOMBRE: <input type="text" name="nombre"></input></p>
            <p>FECHA NACIMIENTO: <input type="date" name="fechaNacimiento"></input></p>
            <input type="submit" value="Guardar" name="botonGuardar"></input>
            <input type="submit" value="Regresar" name="botonRegresarMenu"></input>
        </form>
    </body>
</html>
