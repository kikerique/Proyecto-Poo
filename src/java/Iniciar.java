/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
public class Iniciar extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession sesion = request.getSession();
         String nom="";
        nom = (String)sesion.getAttribute("nom");
        try (PrintWriter out = response.getWriter()) {
        if(nom==null)
        {
            
        response.sendRedirect("http://localhost:8080/Proyecto-poo/index.html");
        }
        String Preguntas []=new String[10];
        int k=0;
        int p=1;
       
        while(k<2){
            Connection connectionBD = null;
        Statement sql = null;
      
         
            Class.forName("com.mysql.jdbc.Driver");
           
            connectionBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_poo","root","root");
              
                 out.println("Algo");
            sql = connectionBD.createStatement();
         
            ResultSet result = sql.executeQuery("select * from preguntas where id='"+p+"' ;");
            if(result.next()){
                          
                  Preguntas[k]= result.getString("pregunta");
                 
            }
             p=p+1;
                  k=k+1;
            
        }
        int z=30;
        k=0;
        
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cuestionario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='post' action='Resultado'>");
            while(k<2)
            {
            out.println("" + Preguntas[k]); 
            out.println("<br>");
            out.println("<input type='text' name='p"+k+"'>");
            out.println("<br>");
            out.println("<br>");
            out.println("<br>");
            k=k+1;
            }
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            while(z<3600)
            {
                try
                {
            Thread.sleep(1000);
                }
                catch(Exception e)
                {
                    out.println("" + e);
                }
            out.println("Tiempo restante" + z +" segundos" );
            z=z-1;
            }
            response.sendRedirect("http://localhost:8080/Poyecto_poo/Menu.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
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
