<%-- 
    Document   : Iniciar
    Created on : 15/11/2017, 08:26:16 AM
    Author     : Marcus
--%>

<%@page import="java.util.Random"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%  int tiempo=3000; %>
    <script> 
        setTimeout(function(){ alert("Hello"); }, 3000);
    </script>
    <head>
        <%
             HttpSession sesion = request.getSession();
         String nom="";
        nom = (String)sesion.getAttribute("nom");
       
       
        if(nom==null)
        {
            
        response.sendRedirect("http://localhost:8080/Proyecto-poo/index.html");
        }
        String Preguntas []=new String[10];
        int k=0;
        int z=0;
        int w=0;
        int p=0;
        int x=0;
        p=(int) (Math.random()*6)+1;
        p=1;
        int entero[]=new int[10];
       entero[0]=-1;entero[1]=-1; entero[2]=-1; entero[3]=-1; entero[4]=-1; entero[5]=-1; entero[6]=-1; entero[7]=-1;  entero[8]=-1;  entero[9]=-1;
       while(w<3)
       {
           while(z<3)
           {
               if(entero[z]==p)
               {
                   p=(int) (Math.random()* 6)+1;
                   z=-1;
               }
               z=z+1;
           }
           entero[w]=p;
           p=(int) (Math.random()*6)+1;
          z=0; 
         w=w+1;  
       }
       out.print(" " + entero[0] );
       out.print(" " + entero[1] );
       out.print(" " + entero[2] );
               
               
        while(k<3){
            Connection connectionBD = null;
        Statement sql = null;
      
         
            Class.forName("com.mysql.jdbc.Driver");
           
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_poo","root","root");
              
                 
            sql = connectionBD.createStatement();
         
            ResultSet result = sql.executeQuery("select * from preguntas where idP='"+entero[x]+"' ;");
            if(result.next()){
                          
                  Preguntas[k]= result.getString("pregunta");
                 
            }
            
                 x=x+1;
                  k=k+1;
            
        }
         z=0;
        k=0;
                
        
            %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   
   
        
                       
            </head>
            <body>
            <form method='post' action='Resultado'>
                <% while(k<3)
            {
            out.println("" + Preguntas[k]); 
            out.println("<br>");
            out.println("<input type='text' name='p"+k+"'>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            k=k+1;
            }
            %>
            </form>
            </body>
            </html>
