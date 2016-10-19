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
        <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
          <link href="/css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Carrito</title>
    </head>
    <body>
        <%!
            ArrayList<Libro> libros = new ArrayList<Libro>();
      
        %>
        <article>
            <header>
         <h1 class = 'jumbotron'>Tienda online libreria Kikeli </h1>
            </header>
        <form action="TiendaLibros.jsp">
       
        <h2>Seleccione Libro</h2>
    
             <%
                
              HttpSession sesion = request.getSession();
            if(request.getParameter("addCesta")!=null){
                if(request.getParameter("lista")==null){
                    %><p id="error">No ha seleccionado libro</p><%
                }
               
                try{
                      Libro libro = new Libro(request.getParameter("lista"), Integer.parseInt(request.getParameter("cantidad")));
                   if(!comprobarRepe(libros, libro)) {
              
                libros.add(libro);}
                 
                       
                sesion.setAttribute("lista", libros);
                 %>
                 <p> Se ha metido <strong><%=request.getParameter("cantidad")%></strong> libros titulados "<strong><em><%=request.getParameter("lista")%></em></strong>"</p>
               
        <%
                }catch(NumberFormatException e){
                  %><p id ='error'>Se ha insertado un caracter no válido</p><%
                }
            }
            
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
        <input type='submit' value='Añadir a la cesta' name='addCesta' class="btn btn-info"/>
        <input type='submit' value ='Limpiar' name='limpiar' class='btn btn-warning'/>
        <input type='submit' value='Finalizar Compra' name='showCarrit' class='btn btn-success'/>
  <%}
           if(request.getParameter("showCarrit")!=null){
        try{
            %>
            
                <body>
                     <table border ='1' class='table table-striped'>
                            <tr>
                                <th>Titulo</th><th>Cantidad</th>
                            </tr>
                            
                    <%ArrayList<Libro> libretes =(ArrayList<Libro>) sesion.getAttribute("lista");
                        for(int i=0; i<libretes.size();i++){%>
                       
                            
                            <tr>
                                <td><%=libretes.get(i).getTitulo()%><td><%=libretes.get(i).getCantidad()%></td>
                            </tr>
                     
                    <%}
//invalido la sesion tras imprimir los datos
                    sesion.invalidate();
}catch(NullPointerException e){
%><p id='error'>Carrito vacío</p><%
}
                    %>
                       </table>
                       <em><a href='TiendaLibros.jsp' name ='volver'> volver</a></em>
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
        <%
            if(request.getParameter("limpiar")!=null){
           request.setAttribute("cantidad", "");
        }
          
        %>
       <footer class="footer" id ="pie">
                <p id="textFoot">@Enrique Ramírez Parra<br> 
                   Correo: rpk1994@gmail.com</p>
        </footer>
    </body>
</html>
