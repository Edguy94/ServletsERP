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
import javax.servlet.http.HttpSession;
/**
 *
 * @author rpk19
 */
public class ContadroVisitasSession extends HttpServlet {

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
            //Inicio la sesion
            HttpSession sesion = request.getSession(true);
            //si el atributo sesion no existe, lo creo y lo inicializo en 0
            if(sesion.getAttribute("CONTADOR")==null)
            sesion.setAttribute("CONTADOR", "1");
            else
                //si existe, sumare en 1 el contador de visitas
                sesion.setAttribute("CONTADOR", Integer.parseInt(sesion.getAttribute("CONTADOR").toString())+1);
            
            //si dejo checkada la opcion de invalidar, me cargo la sesion
            if(request.getParameter("invalidar")!=null){
                sesion.invalidate();
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadroVisitasSession</title>");  
             out.write("<link href='css/bootstrap.css' rel='stylesheet' type='text/css'/>");
             out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");                    
            out.println("</head>");
            out.println("<body>");
            out.println("<article>");
            out.println("<header>");
            out.println("<h1 class = 'jumbotron'>Contador visitas con sesiones</h1>");
            out.println("</header>");
            out.println("<div id=centrar>");
            out.println("<form action ='/ContadroVisitasSession'>");
          try{
            out.println("<h2>Has visitado esta página "+sesion.getAttribute("CONTADOR")+" veces</h2>");
          }catch(Exception e){
              out.println("<h2> La sesion se invalidó</h2>");
          }
             out.println("<input type='checkbox'  value = 'invalidar' name = 'invalidar'/> Invalidar visita <br>"
                     + "<input type='submit' value ='Refrescar' name = 'refrescar' class='btn btn-info'/><br>"
                     + "<em><a href='/index.html'>volver</a></em>");
              out.println("</form >");
              out.println("</div>");
                out.println(" <footer class=\"footer\" id =\"pie\">\n" +
"                <p id=\"textFoot\">@Enrique Ramírez Parra<br>\n" +
"                    Correo: rpk1994@gmail.com</p>\n" +
"            </footer>");
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
