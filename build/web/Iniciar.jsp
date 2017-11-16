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
  
</script>
    <%  
         HttpSession sesion = request.getSession();
         String tiemposs=(String)sesion.getAttribute("tiempoS");
    
    int tiempoS=Integer.parseInt(tiemposs);
    out.println("<input type='hidden' name='ayuda' id='ayuda' value='"+tiempoS+"'>");
  
    %>
    
   
    <script> 
   var cronometro;

 

    function detenerse()

    {

        clearInterval(cronometro);

    }

 

   function carga()

    {
       
          var ayuda=document.getElementById("ayuda").value;
         var s2=parseInt(ayuda);
        contador_s =s2;
                

        s = document.getElementById("segundos");

       if(contador_s>=15)
                {
                    
                document.f1.submit();
            }
 

        cronometro = setInterval(

            function(){
                 s.innerHTML = contador_s;
                contador_s++;
                  document.f1.T.value = contador_s;
               
                

                if(contador_s>=15)
                {
                    
                document.f1.submit();
            }
            }

            ,1000);

 

    }

    </script>
    <head>
        <%
             
         String nom="";
         String Status="";
        nom = (String)sesion.getAttribute("nom");
        Status = (String)session.getAttribute("status");
       
        if(nom==null)
        {
            
        response.sendRedirect("http://localhost:8080/Proyecto-Poo/Menu.jsp");
        }
           if(Status.equals("Si"))
        {
            
        response.sendRedirect("http://localhost:8080/Proyecto-Poo/index.html");
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
    
               sesion.setAttribute("p1", entero[0]);
               sesion.setAttribute("p2", entero[1]);
               sesion.setAttribute("p3", entero[2]);
               
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
            <body onload="carga()">

 <p>

     tiempo transcurrido segundos  <span id="segundos">0</span>

    </p>
            <form method='post' action='Intermedio.jsp' name="f1" id="f1">
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
            <input type="hidden" name="T" id="T" >
            
            <input type="submit" name="fin" value="pausar reaunudar">
            </form>
            <div id="number">   </div>
            </body>
            </html>
