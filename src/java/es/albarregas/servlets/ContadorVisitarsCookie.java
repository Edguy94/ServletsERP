/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rpk19
 */
public class ContadorVisitarsCookie extends HttpServlet {

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
        Cookie wookie = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("CONTADOR")){
                    wookie = cookies[i];
                     cookies[i].setValue(Integer.toString(Integer.parseInt(wookie.getValue())+1));
                }
                
            }
        }
        if(wookie == null){
            wookie = new Cookie("CONTADOR", "0");
        }
       if(request.getParameter("borrar")!=null){
       wookie.setValue("0");
       }
        
        response.addCookie(wookie);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.write("<link href='css/bootstrap.css' rel='stylesheet' type='text/css'/>");
             out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");                    
            out.println("<title>Servlet ContadorVisitarsCookie</title>");            
            out.println("</head>");
            out.println("<body>");
              out.println("<article>");
              out.println("<header>");
            out.println("<h1 class='jumbotron'> Contador de visitas con cookies </h1>");
              out.println("</header>");
               out.println("<div id='centrar'>");
                 out.write("<form action = '/ContadorVisitarsCookie'>");
            out.println("<h2>Has visitado esta página "+wookie.getValue()+" veces</h2>");
            out.println("<input type='submit' value='BorrarCookie' name='borrar' class='btn btn-info'/><br>"
                    + "<input type='submit' value = 'Refrescar' name ='refrescar' class ='btn btn-warning'/><br>"
                    + "<em><a href='/index.html'>volver</a></em>");
                 out.write("</form>");
                  out.println("</div>");
                   out.println(" <footer class=\"footer\" id =\"pie\">\n" +
"                <p id=\"textFoot\">@Enrique Ramírez Parra<br>\n" +
"                    Correo: rpk1994@gmail.com</p>\n" +
"            </footer>");
                 out.println("</article>");
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
