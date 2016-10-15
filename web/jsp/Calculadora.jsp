<%-- 
    Document   : Calculadora
    Created on : 15-oct-2016, 11:25:35
    Author     : rpk19
--%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="/css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <article>
           
        <form action="Calculadora.jsp">
             <header>
                 <h1 class="jumbotron">Calculadora </h1><br>
             </header>
            <div class ='row' id = 'login'>
        Primer operando: <input type="text" name ="numUno"/> Segundo Operando: <input type="text" name="numDos"/><br>
        <input type="radio" name="operar" value = "sum"/> Sumar
        <input type="radio" name="operar" value = "rest"/> Restar
        <input type="radio" name="operar" value = "mul"/>  Multiplicar
        <input type="radio" name="operar" value = "divi"/> Dividir
        <br>
        <input type="submit" value ="Calcular" name = "Calcular" class="btn btn-success"/>
        <input type="submit" value ="Limpiar" name ="Limpiar" class="btn btn-warning"/><br>
        <em><a href='/index.html'>volver</a></em>
            </div>
         <footer class="footer" id ="pie">
              <p id="textFoot">@Enrique Ramírez Parra<br> 
                    Correo: rpk1994@gmail.com</p> 
            </footer>
        </article>
<!--Metodos de la calculadora-->
<%
if(request.getParameter("Calcular")!=null){
    //cojo los valores de las cajas de texto y el valor de operar
    int numUno=0, numDos=0;
     String operacion = request.getParameter("operar");
    try{
     numUno = Integer.parseInt(request.getParameter("numUno"));
     numDos = Integer.parseInt(request.getParameter("numDos"));
    }catch(NumberFormatException e){
        out.println("<p id='error'>Error al introducir alguno de los valores a calcular</p>");
        operacion = "";
    }
   
 
    switch(operacion){
        case "sum":
       out.println("<p>El resultado de la operacion "+numUno+"+"+numDos+"="+(numUno+numDos)+"</p>");
            break;
        case "rest":
             out.println("<p>El resultado de la operacion "+numUno+"-"+numDos+"="+(numUno-numDos)+"</p>");
            break;
       
        case "mul":
             out.println("<p>El resultado de la operacion "+numUno+"x"+numDos+"="+(numUno*numDos)+"</p>");
            break;
        case "divi":
            try{
             out.println("<p>El resultado de la operacion "+numUno+"/"+numDos+"="+(numUno/numDos)+"</p>");
            }catch(ArithmeticException e){
                out.println("<p id='error'>División entre 0</p>");
            }    
            break;
            
    }
  
}
if(request.getParameter("Limpiar")!=null){
    request.setAttribute("numUno","");
    request.setAttribute("numDos","");
}
 %>

        </form>
    </body>
</html>
