<%-- 
    Document   : newjsp
    Created on : 21/09/2019, 09:27:59 AM
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENU</title>
    </head>
    <body>
        <h1>SELECCIONE UNA OPCION</h1>
        <form action="MenuServlet" method="post" >
            <input type="submit" value="REGISTRAR USUARIO" name="boton1"  ></input>
            <br><br>            
            <input type="submit" value="REGISTRAR ESTUDIANTE" name="boton2"></input>
        </form>
    </body>
</html>
