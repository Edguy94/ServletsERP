<%-- 
    Document   : TiendaLibros
    Created on : 17-oct-2016, 18:10:59
    Author     : rpk19
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="es.albarregas.beans.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
    </head>
    <body>
        <%!
            ArrayList<Libro> libros = new ArrayList<Libro>();
      
        %>
        <form action="TiendaLibros.jsp">
        <h1>Tienda online libreria Kikeli </h1>
        <h2>Seleccione Libro</h2>
    
             <%
                
             HttpSession sesion = request.getSession();
            if(request.getParameter("addCesta")!=null){
                try{
                      Libro libro = new Libro(request.getParameter("lista"), Integer.parseInt(request.getParameter("cantidad")));
                   if(!comprobarRepe(libros, libro)) {
              
                libros.add(libro);}
                   else
                       
                sesion.setAttribute("lista", libros);
                 %>
                 <p> Se ha metido <strong><%=request.getParameter("cantidad")%></strong> libros titulados "<strong><em><%=request.getParameter("lista")%></em></strong>"</p>
                 <p><%=libros.size()%>
        <%
                }catch(NumberFormatException e){
                  %><p>Se ha insertado un caracter no válido</p><%
                }
            }%>
            <%
           if(request.getParameter("showCarrit")==null){
          
            %>
        <select size ='10' name ='lista'>
            <option> Juego de tronos </option>
            <option> Harry Potter </option>
            <option> Millenium </option>
            <option> Los pilares de la tierra</option>
            <option> 20.000 leguas de viaje submarino</option>
            <option> Dracula</option>
            <option> El ultimo mohicano</option>
            <option> El señor de los anillos</option>
            <option> Robinson Crusoe </option>
            <option> El conde de montecristo </option>
        </select><br>
        <h2> Cantidad</h2><br>
        <input type='text' name ='cantidad'/><br>
        <input type='submit' value='Añadir a la cesta' name='addCesta'/>
        <input type='submit' value ='Limpiar' name='limpiar'/>
        <input type='submit' value='Finalizar Compra' name='showCarrit'/>
  <%}
           if(request.getParameter("showCarrit")!=null){
        
            %>
            
                <body>
                     <table border ='1'>
                            <tr>
                                <th>Titulo</th><th>Cantidad</th>
                            </tr>
                            
                    <%ArrayList<Libro> libretes =(ArrayList<Libro>) sesion.getAttribute("lista");
                        for(int i=0; i<libretes.size();i++){%>
                       
                            
                            <tr>
                                <td><%=libretes.get(i).getTitulo()%><td><%=libretes.get(i).getCantidad()%></td>
                            </tr>
                     
                    <%}%>
                       </table>
                       <em><a href='TiendaLibros.jsp'> volver</a></em>
                </body>
           
        <%
           }
            
        %>
        </form>
        <%!
            /**
             * Este metodo comproara si hay repetidos en la lista que le pase.
             */
        public boolean comprobarRepe(ArrayList<Libro> libros, Libro libro){
        for(Libro librete : libros){
//si el libro esta repe, incrementara la cantidad del libro en el arraylist sumandole la
//cantidad del nuevo libro que se pasa por parametro y se esta comprobando.
        if(librete.getTitulo().equals(libro.getTitulo())){
            librete.setCantidad(librete.getCantidad()+libro.getCantidad());
            return true;
    }
        }
return false;
}
        %>
        
    </body>
</html>
