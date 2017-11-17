/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Marcus
 */
public class Login extends HttpServlet {

   
  

  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
              HttpSession sesion = request.getSession();

                        
   Connection connectionBD = null;
        Statement sql = null;
        String email = request.getParameter("correo");
         String contr = request.getParameter("contra");
         
            Class.forName("com.mysql.jdbc.Driver");
           
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_poo","root","root");
              
            sql = connectionBD.createStatement();
            ResultSet result = sql.executeQuery("select * from usuario where correo ='"+email+"' and contrasena ='"+contr+"';");
           
             if(result.next()){
                  out.println("Algo");
                  
                  String id= result.getString("id");
                  String nom = result.getString("nombre");
                  String status=result.getString("estatus");
                  String correo=result.getString("correo");
                if(status.equals("No"))
                {
                     sesion.setAttribute("tiempoS", "0");
                }
                else{
                     sesion.setAttribute("tiempoS", "16");
                }
                  sesion.setAttribute("NombreEmpleado", nom);
         sesion.setAttribute("id", id);
         sesion.setAttribute("nom", nom);
         sesion.setAttribute("status", status);
         sesion.setAttribute("correo", correo);
         sesion.setAttribute("status2" , "listo" );
          sesion.setAttribute("r1", "");
         sesion.setAttribute("r1", "");
     sesion.setAttribute("r2", "");
     sesion.setAttribute("r3", "");
      sesion.setAttribute("p1", "");
     sesion.setAttribute("p2", "");
     sesion.setAttribute("p3", "");
     sql.close();
     
     connectionBD.close();
         out.println(""+status);
                  response.sendRedirect("http://localhost:8080/Proyecto-Poo/Menu.jsp");
                  
             }
             
             else{
                    sql.close();
     connectionBD.close();  
              response.sendRedirect("http://localhost:8080/Proyecto-Poo/index.html");
               
             }
           
       
    }
    }
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
    }
}
