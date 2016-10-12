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
public class CicloVida extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      PrintWriter out = resp.getWriter();
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
           
            out.write("<link href='css/bootstrap.css' rel='stylesheet' type='text/css'/>");
             out.write("<link href='css/estilos.css' rel='stylesheet' type='text/css'/>");
            out.println("<title>Servlet Ciclo vida</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<article>");
            
            out.println("<header>");
            out.println("<h1 class='jumbotron'>El ciclo de vida se muestra en la consola </h1>");
                  out.println("</header>");
                  
                  
              out.write("<em><a href='/index.html'>volver</a></em>");
              
              out.println(" <footer class=\"footer\" id =\"pie\">\n" +
"                <p id=\"textFoot\">@Enrique Ramírez Parra<br>\n" +
"                    Correo: rpk1994@gmail.com</p>\n" +
"            </footer>");
              out.println("</article>");
            out.println("</body>");
            out.println("</html>");
        System.out.println("Estoy en el service");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Estoy en el init");
    }

    @Override
    public void destroy() {
      System.out.println("Estoy en el destroy");
    }
    
    

}
