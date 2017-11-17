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
          
          if(ayuda != null)
          {
         var s2=parseInt(ayuda);
        contador_s =s2;
    }
    else
    {
        contador_s=15;
    }
         

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
        String respuestas[]=new String[10];
        respuestas[0]=(String)sesion.getAttribute("r1");
          respuestas[1]=(String)sesion.getAttribute("r2");
            respuestas[2]=(String)sesion.getAttribute("r3");
            
        String ayuda=(String)sesion.getAttribute("status2");
        String np[]=new String[10];
        
        int entero[]=new int[10];
         entero[0]=-1;entero[1]=-1; entero[2]=-1; entero[3]=-1; entero[4]=-1; entero[5]=-1; entero[6]=-1; entero[7]=-1;  entero[8]=-1;  entero[9]=-1;
           if(ayuda.equals("listo"))
           {
       
       
        p=(int) (Math.random()*6)+1;
        p=1;
        
      
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
        np[0]=Integer.toString(entero[0]);
          np[1]=Integer.toString(entero[1]);
            np[2]=Integer.toString(entero[2]);
               sesion.setAttribute("p1",np[0]);
               sesion.setAttribute("p2",np[1]);
               sesion.setAttribute("p3",np[2]);
               sesion.setAttribute("status2" , "empezado" );
           }
           else
           {
            
               np[0]=(String)sesion.getAttribute("p1");
               np[1]=(String)sesion.getAttribute("p2");
               np[2]=(String)sesion.getAttribute("p3");
             
                          
           }
               
        while(k<3){
            Connection connectionBD = null;
        Statement sql = null;
      
         
            Class.forName("com.mysql.jdbc.Driver");
           
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_poo","root","root");
              
                 
            sql = connectionBD.createStatement();
         
            ResultSet result = sql.executeQuery("select * from preguntas where idP='"+np[x]+"' ;");
            
            if(result.next()){
                          
                  Preguntas[k]= result.getString("pregunta");
                 
            }
            
                 x=x+1;
                  k=k+1;
               sql.close();
     connectionBD.close();
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
            out.println("<input type='text' name='p"+k+"' value='"+respuestas[k]+"'>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            k=k+1;
            }
            
                
                
            %>
            <input type="hidden" name="T" id="T" value="20" >
            
            <input type="submit" name="fin" value="pausar reaunudar">
            </form>
            <div id="number">   </div>
            </body>
            </html>
