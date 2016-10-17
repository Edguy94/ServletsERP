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
        <form action="TiendaLibros.jsp">
        <h1>Tienda online libreria Kikeli </h1>
        <h2>Seleccione Libro</h2>
        <%String mensaje ="";%><br>
        <label name ='mensaje'><%=mensaje%></label>
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
        <%
            ArrayList<Libro> libros = new ArrayList<Libro>();
            if(request.getParameter("addCesta")!=null){
                try{
                libros.add(new Libro(request.getParameter("lista"), Integer.parseInt(request.getParameter("cantidad"))));
                  mensaje="Se ha añadido a la cesta "+request.getParameter("cantidad")+" del libro "+request.getParameter("lista");
                }catch(NumberFormatException e){
                    mensaje = "Cantidad incorrecta";
                }
            }
        %>
        </form>
    </body>
</html>
