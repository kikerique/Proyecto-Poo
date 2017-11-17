/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Marcus
 */
public class Fin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession sesion = request.getSession();
        try (PrintWriter out = response.getWriter()) {
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultados</title>");            
            out.println("</head>");
            out.println("<body>");
               out.println("<h1>Tus respuestas </h1>");
           int k=0;
           int z=0;
            String idp[]= new String[10];
            String resp[]=new String[10];
            String respC[]=new String[10];
            resp[0]=(String)sesion.getAttribute("r1");
            resp[1]=(String)sesion.getAttribute("r2");
            resp[2]=(String)sesion.getAttribute("r3");
            idp[0]=(String)sesion.getAttribute("p1");
                 idp[1]=(String)sesion.getAttribute("p2");
               idp[2]=(String)sesion.getAttribute("p3");
          
               while(k<3) {
                Connection connectionBD = null;
        Statement sql = null;
       
         
            Class.forName("com.mysql.jdbc.Driver");
            
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_poo","root","root");
              
            sql = connectionBD.createStatement();
            ResultSet result = sql.executeQuery("select * from preguntas where idP ='"+idp[k]+"';");
       
           
             if(result.next())
             {
                
                 out.print("tu respuesta: " + resp[k] + "<br>  la respuesta correcta es:  " + result.getString("respuesta") + "    <br>tu respuesta es:  " );
                  
                 if(resp[k].equalsIgnoreCase(result.getString("respuesta")) )
                 {
                     out.print("Correcta");
                     out.print("<br><br>");
                     z=z+1;
                 }
                 else
                 {
                     out.print("Incorrecta");
                     out.print("<br><br>"); 
                 }
             }
             else
             {
                  out.println("valio");
             }
               sql.close();
     k=k+1;
     connectionBD.close();
               }
            out.print("Tu calificacion es  " + z + " de  3");
            
                Connection connectionBD = null;
        Statement sql = null;
       
         
            Class.forName("com.mysql.jdbc.Driver");
            
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_poo","root","root");
              String idu=(String)sesion.getAttribute("id");
            sql = connectionBD.createStatement();
            String Status="Si";
            int res = sql.executeUpdate("Update usuario set estatus='"+Status+"'  where id ='"+idu+"';");
            sesion.setAttribute("status", "Si");
                sql.close();
    
     connectionBD.close();
     out.print("<form method='post' action='Menu.jsp'>");
     out.print("<input type='submit' value='Menu'>");
     out.print("</from>");
     
     
      out.println("</body>");
            out.println("</html>");
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
