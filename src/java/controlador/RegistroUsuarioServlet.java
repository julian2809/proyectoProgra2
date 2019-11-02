/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.colaInscripcion;
import modelo.listaUsuario;
import modelo.pilaEstudiantes;
import modelo.usuarioDto;
import servicio.Servicios;

/**
 *
 * @author julia
 */
@WebServlet(name = "RegistroUsuarioServlet", urlPatterns = {"/RegistroUsuarioServlet"})
public class RegistroUsuarioServlet extends HttpServlet {
    Servicios servicio = new Servicios();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            servicio.setListaUsuariosDinamica((listaUsuario) request.getSession().getAttribute("lista"));
            servicio.setPilaEstudiante((pilaEstudiantes) request.getSession().getAttribute("pila"));
            servicio.setColaEstudiantes((colaInscripcion) request.getSession().getAttribute("cola"));
            String botonGuardar = request.getParameter("botonGuardar");
            String botonRegresar = request.getParameter("botonRegresar");
            String botonRegresarMenu = request.getParameter("botonRegresarMenu");
            String usuario = request.getParameter("user");
            String password = request.getParameter("pass");
            if (botonGuardar != null && botonGuardar.equals("Guardar")) {
//                if (servicio.getListaUsuariosDinamica().listaVacia()){
//                    servicio.cargarUsuarios();
//                }
                usuarioDto usuarioNuevo = new usuarioDto(usuario, password);
                servicio.setListaUsuariosDinamica(servicio.getListaUsuariosDinamica().push(usuarioNuevo));
                //servicio.grabarUsuarios();
                //GENERANDO PAGINA DE RESPUESTA
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<title>Usuario Guardado</title>");
                out.println("</head>");
                out.println("<body>");
                out.print("<form action=\"RegistroUsuarioServlet\" method=\"post\">");
                out.println("<h1>USUARIO GUARDADO CON EXITO</h1>");
                out.println("<input type=\"submit\" value=\"Regresar\" name=\"botonRegresar\"></input>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }else if (botonRegresar != null && botonRegresar.equals("Regresar")) {
                request.getSession().setAttribute("lista", servicio.getListaUsuariosDinamica());
                request.getSession().setAttribute("pila", servicio.getPilaEstudiante());
                request.getSession().setAttribute("cola", servicio.getColaEstudiantes());
                request.getSession().setAttribute("mostrarUsuarios", servicio.mostrarUsuarios());
                request.getSession().setAttribute("mostrarPila", servicio.mostrarPila());
                request.getSession().setAttribute("mostrarCola", servicio.mostrarCola());
                response.sendRedirect("registrarUsuarios.jsp");
            }else if (botonRegresarMenu !=null && botonRegresarMenu.equals("Regresar")){
                request.getSession().setAttribute("lista", servicio.getListaUsuariosDinamica());
                request.getSession().setAttribute("pila", servicio.getPilaEstudiante());
                request.getSession().setAttribute("cola", servicio.getColaEstudiantes());
                request.getSession().setAttribute("mostrarUsuarios", servicio.mostrarUsuarios());
                request.getSession().setAttribute("mostrarPila", servicio.mostrarPila());
                request.getSession().setAttribute("mostrarCola", servicio.mostrarCola());
                response.sendRedirect("menu.jsp");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
