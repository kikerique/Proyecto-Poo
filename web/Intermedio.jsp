<%-- 
    Document   : Intermedio.jsp
    Created on : 15/11/2017, 07:39:26 PM
    Author     : Marcus
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pausa</title>
        <%  
              HttpSession sesion = request.getSession();
     String r0=request.getParameter("p0");
     String r1=request.getParameter("p1");
     String r2=request.getParameter("p2");
     sesion.setAttribute("r1", r0);
     sesion.setAttribute("r2", r1);
     sesion.setAttribute("r3", r2);
    
     String tiempoS=request.getParameter("T");
     sesion.setAttribute("tiempoS", tiempoS);
     
     String respuestas[] = new String[10];
     respuestas[0]=request.getParameter("p0");
     respuestas[1]=request.getParameter("p1");
     respuestas[2]=request.getParameter("p2");
   
            sesion.setAttribute("r1", respuestas[0]);
            sesion.setAttribute("r2", respuestas[1]);
            sesion.setAttribute("r3", respuestas[2]);
     
        %>
    </head>
    <body>
        <h1>
            <form action="Iniciar.jsp" method="post">
                <input type="submit" name="return" value="regresar">
            </form>
              <form action="Fin" method="post">
                <input type="submit" name="return" value="Terminar">
            </form>
            
            
        </h1>
    </body>
</html>
