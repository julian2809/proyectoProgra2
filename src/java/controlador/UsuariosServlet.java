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
import servicio.Servicios;

/**
 *
 * @author julia
 */
@WebServlet(name = "UsuariosUI", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

    Servicios servicio;

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
            servicio  = new Servicios();
            String usuario = request.getParameter("user");
            String password = request.getParameter("pass");
            /* TODO output your page here. You may use following sample code. */
            servicio.cargarUsuarios();
            servicio.cargarPila();
            servicio.cargarCola();
            if (servicio.comprobarUsuarios(usuario, password)) {
                request.getSession().setAttribute("lista",servicio.getListaUsuariosDinamica());
                request.getSession().setAttribute("pila",servicio.getPilaEstudiante());
                request.getSession().setAttribute("cola", servicio.getColaEstudiantes());
                request.getSession().setAttribute("mostrarUsuarios", servicio.mostrarUsuarios());
                request.getSession().setAttribute("mostrarPila",servicio.mostrarPila());
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
