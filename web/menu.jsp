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
            <br><br> 
            <input type="submit" value="AGREGAR A COLA DE INSCRIPCION" name="boton3"></input>
            <br><br>
            <input type="submit" value="SACAR DE COLA DE INSCRIPCION" name="boton4"></input>
            <br><br>
            <input type="submit" value="CERRAR SESION" name="botonCerrar"></input>
            <br><br>
            <p><%
                HttpSession s = request.getSession();
                %>
                Usuarios:<%
                out.println(s.getAttribute("mostrarUsuarios"));
                %>
                Pila Estudiantes:<%
                out.println(s.getAttribute("mostrarPila"));
                %>
                Cola inscripcion:<%
                out.println(s.getAttribute("mostrarCola"));               
            %></p>
        </form>
    </body>
</html>
