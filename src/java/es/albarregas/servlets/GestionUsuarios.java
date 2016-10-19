/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import es.albarregas.beans.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rpk19
 */
public class GestionUsuarios extends HttpServlet {

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
              HttpSession sesion = request.getSession();
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("enviar")==null && request.getParameter("continuar")==null){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>");
  out.write("<link href='css/bootstrap.css' rel='stylesheet' type='text/css'/>");
             out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");                                
            out.println("</head>");
            out.println("<body>");
             out.println("<article>");
              out.println("<header>");
               
            out.println("<h1 class ='jumbotron'> Gestion Usuarios </h1>");
             out.println("</header>");
             
             out.println("<form action='/GestionUsuarios'>");
              out.println("<section class='row'>");
               out.println("<div class='col-sm-3'>");
           out.println("<p>Id uno<input type='text' name ='idUno'/><br>"+
                  " Nombre uno<input type='text' name ='nombreUno'/><br>"+
                   "Sueldo uno<input type='text' name ='sueldoUno'/></p>");
           out.println("</div>");
            out.println("<div class='col-sm-3'>");
            out.println("<p>Id dos<input type='text' name ='idDos'/><br>"+
            "Nombre dos<input type='text' name ='nombreDos'/><br>"+
            "Sueldo dos<input type='text' name ='sueldoDos'/></div>"+
           "</p>");
            out.println("</div>");
             out.println("<div class='col-sm-3'>");
            out.println("<p>"+
                    "Id tres<input type='text' name ='idTres'/><br>"+
           "Nombre tres<input type='text' name ='nombreTres'/><br>"+
           "Sueldo tres<input type='text' name ='sueldoTres'/></p></div><br>");
            out.println("</section>");
              
            out.println("<input type='submit' value ='Enviar' name ='enviar' class='btn btn-info'/>");
             out.println("</form>");
              out.println(" <footer class=\"footer\" id =\"pie\">\n" +
"                <p id=\"textFoot\">@Enrique Ramírez Parra<br>\n" +
"                    Correo: rpk1994@gmail.com</p>\n" +
"            </footer>");
             out.println("</article>");
            out.println("</body>");
            out.println("</html>");
        }else if(request.getParameter("enviar")!=null){
                ArrayList<Usuario> lista = new ArrayList<Usuario>();
              
                       
                lista.add(new Usuario(Integer.parseInt(request.getParameter("idUno")), request.getParameter("nombreUno"), Double.parseDouble(request.getParameter("sueldoUno"))));
                lista.add(new Usuario(Integer.parseInt(request.getParameter("idDos")), request.getParameter("nombreDos"), Double.parseDouble(request.getParameter("sueldoDos"))));
                lista.add(new Usuario(Integer.parseInt(request.getParameter("idTres")), request.getParameter("nombreTres"), Double.parseDouble(request.getParameter("sueldoTres"))));
              
                sesion.setAttribute("listaUsers", lista);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>");     
            out.write("<link href='css/bootstrap.css' rel='stylesheet' type='text/css'/>");
             out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");                                
            out.println("</head>");
            out.println("<body>");
            out.println("<article>");
            out.println("<header>");
           out.println("<h1 class='jumbotron'>Gestion de usuarios</h1>");
           out.println("</header>");
           out.println("<h3>Datos almacenados</h3>");
            out.println("<form action='/GestionUsuarios'>");
           out.println("<input type='submit'value='Continuar' name = 'continuar' class='btn btn-success'/>");
            out.println("</form>");
             out.println(" <footer class=\"footer\" id =\"pie\">\n" +
"                <p id=\"textFoot\">@Enrique Ramírez Parra<br>\n" +
"                    Correo: rpk1994@gmail.com</p>\n" +
"            </footer>");
             out.println("</article>");
            out.println("</body>");
            out.println("</html>");
            }
            
            if(request.getParameter("continuar")!=null){
                ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) sesion.getAttribute("listaUsers");
                  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>"); 
              out.write("<link href='css/bootstrap.css' rel='stylesheet' type='text/css'/>");
             out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");                                
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1 class='jumbotron'> Datos almacenados </h1>");
            out.println("</header");
            out.println("<div id='muestraDatos'>");
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    out.print("<p>Usuario "+(i+1)+" Id: "+listaUsuarios.get(i).getId()+" nombre: "+listaUsuarios.get(i).getNombre()+" sueldo: "+listaUsuarios.get(i).getSueldo()+"</p>");
                    
                }
                out.println("</div>");
                out.println("<em><a href='/index.html'>volver</a></em>");
                out.println(" <footer class=\"footer\" id =\"pie\">\n" +
"                <p id=\"textFoot\">@Enrique Ramírez Parra<br>\n" +
"                    Correo: rpk1994@gmail.com</p>\n" +
"            </footer>");
                out.println("</article>");
            out.println("</body>");
            out.println("</html>");
            }
            
            
    }}

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
