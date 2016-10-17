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
            if(request.getParameter("enviar")==null){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Gestion Usuarios </h1>");
             out.println("<form action='/GestionUsuarios>");
           out.println("<p>Id uno</p><input type='text' name ='idUno'/>"+
           "<p>Id dos</p><input type='text' name ='idDos'/>"+
          "<p>Id tres</p><input type='text' name ='idTres'/>");
           out.println("<br>");
            out.println("<p>Nombre uno</p><input type='text' name ='nombreUno'/>"+
            "<p>Nombre dos</p><input type='text' name ='nombreDos'/>"+
           "<p>Nombre tres</p><input type='text' name ='nombreTres'/>");
            out.println("<br>");
            out.println("<p>Sueldo uno</p><input type='text' name ='sueldoUno'/>"+
            "<p>Sueldo dos</p><input type='text' name ='sueldoDos'/>"+
           "<p>Sueldo tres</p><input type='text' name ='sueldoTres'/>");
          
            
            out.println("<input type='submit' value ='Enviar' name ='enviar'/>");
             out.println("</form>");
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
            out.println("</head>");
            out.println("<body>");
           out.println("<h1>Datos almacenados</h1>");
           out.println("<input type='submit'value='Continuar' name = 'continuar'/>");
            out.println("</body>");
            out.println("</html>");
            }
            
            if(request.getParameter("continuar")!=null){
                ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) sesion.getAttribute("listaUsers");
                  out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GestionUsuarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Datos almacenados </h1>");
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    out.print("<p>Id"+(i+1)+":"+listaUsuarios.get(i).getId()+" nombre"+(i+1)+":"+listaUsuarios.get(i).getNombre()+" sueldo"+(i+1)+":"+listaUsuarios.get(i).getSueldo()+"</p>");
                    
                }
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
