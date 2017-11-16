<%-- 
    Document   : Menu
    Created on : 14/11/2017, 08:32:54 PM
    Author     : Marcus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Menu</title>
  <script type="text/javascript">

window.onunload = sale;
var valor;
if(document.cookie){
	galleta = unescape(document.cookie)
	galleta = galleta.split(';')
	for(m=0; m<galleta.length; m++){
		if(galleta[m].split('=')[0] == "recarga"){
			valor = galleta[m].split('=')[1]
			break;
		}
	}
	if(valor == "sip"){
		document.cookie = "recarga=nop"; 
		window.onunload = function(){};
		document.location.reload()
	}
	else{
	window.onunload=sale
	}
}
function sale(){
	document.cookie ="recarga=sip"
}
</script>


        <meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
     
    </head>
                         <%
                             HttpSession sesion = request.getSession();
                            
String nom = (String)session.getAttribute("nom");
if(nom==null){
   response.sendRedirect("http://localhost:8080/Proyecto-poo/index.html"); 
}
%>
    <body>
        <h1>Bienvenido Usuario</h1>
        <p align="right">
        <form method="post" action="logout">

            <input type="submit" name="destroy" value="Logout">            
        </form>
    </p>
    <form method="post" action="Iniciar.jsp">
        <input type="submit" name="Start" value="Iniciar">
        
    </form>    
        
    </body>
</html>
