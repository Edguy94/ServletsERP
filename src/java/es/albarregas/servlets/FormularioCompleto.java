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
public class FormularioCompleto extends HttpServlet {

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
            out.println("<title>Servlet FormularioCompleto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Formulario Completo </h1>");
            //datos personales
            out.println("Nombre: <input type='text' value ='nombre' name = 'nombre'/><br>"
                    + "Apellidos: <input type='text' value = 'apellidos' name ='apellidos'/><br>"
                    + "Hombre <input type='radio' name = 'sex'/> Mujer <input type='radio' name = 'sex'/><br>"
                    + "fecha nacimiento: <input type='date' name = 'fechaNac'/><br>");
            //datos acceso
            
            out.println("Usuario: <input type =' text' name ='usuario'/><br>"
                    + "Pass: <input type='text' name ='pass'/><br>"
                    + "Repita el pass <input type='text name ='pass2'/><br>");
            //Info general
            out.println("Aficiones:<br>"
                    + "<input type='checkbox' value = 'Lectura' name = 'lectura'/>Lectura<br>"
                    + "<input type='checkbox' value = 'Depote' name = 'deporte'/> Deporte<br>"
                    + "<input type='checkbox' value = 'Videojuegos' name = 'videojuegos'/>Videojuegos<br>"
                    + "<input type='checkbox' value = 'Programacion' name = 'programacion'/>Programacion<br>");
      
            
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
