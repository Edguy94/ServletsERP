/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rpk19
 */
public class Login extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ejercicio LogIn</h1>");
             out.println("<form method ='POST'/>");
            out.println("Nombre de usuario: <input type='text' name = 'user'/><br>");
            out.println("Contraseña: <input type='text' name = 'pass'/>");
            out.println("<br><input type ='checkbox' value = 'Lectura' name='lectura'/>Lectura<br>"
                    + "<input type ='checkbox' value = 'Deporte' name='deporte'/>Deporte<br>"
                    +"<input type ='checkbox' value = 'Videojuegos' name='videojuegos'/>Videojuegos<br>"
                    + "<input type ='checkbox' value = 'Programar' name='programar'/>Programar<br>"
            );
            out.println("<input type='submit' value = 'LogIn'/>"
                    + "<input type='submit' value ='Limpiar'/><br>");
                 out.write("<em><a href='/index.html'>volver</a></em>");
             out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            
          
         
            
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
