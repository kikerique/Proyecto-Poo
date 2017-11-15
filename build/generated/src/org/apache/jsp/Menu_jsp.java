package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Menu</title>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("window.onunload = sale;\n");
      out.write("var valor;\n");
      out.write("if(document.cookie){\n");
      out.write("\tgalleta = unescape(document.cookie)\n");
      out.write("\tgalleta = galleta.split(';')\n");
      out.write("\tfor(m=0; m<galleta.length; m++){\n");
      out.write("\t\tif(galleta[m].split('=')[0] == \"recarga\"){\n");
      out.write("\t\t\tvalor = galleta[m].split('=')[1]\n");
      out.write("\t\t\tbreak;\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\tif(valor == \"sip\"){\n");
      out.write("\t\tdocument.cookie = \"recarga=nop\"; \n");
      out.write("\t\twindow.onunload = function(){};\n");
      out.write("\t\tdocument.location.reload()\n");
      out.write("\t}\n");
      out.write("\telse{\n");
      out.write("\twindow.onunload=sale\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("function sale(){\n");
      out.write("\tdocument.cookie =\"recarga=sip\"\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("     \n");
      out.write("    </head>\n");
      out.write("                         ");

String nom = (String)session.getAttribute("NombreEmpleado");
String compa = (String)session.getAttribute("compa");
if(nom==null){
     response.setContentType("text/html");  
               out.println("<head>");
                out.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
                out.println("<script src=\"dist/sweetalert.min.js\"></script> <link rel=\"stylesheet\" type=\"text/css\" href=\"dist/sweetalert.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<br>");
                out.println("<script type=\"text/javascript\">");  
                out.println("sweetAlert({\n" +
"    title: \"Error!\",\n" +
"    text: \"Inicia sesion!\",\n" +
"    type: \"error\"\n" +
"},\n" +
"\n" +
"function () {\n" +
"    window.location.href = 'index.html';\n" +
"});"); 
out.println("</script>"); 
}

      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Bienvenido Usuario</h1>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
