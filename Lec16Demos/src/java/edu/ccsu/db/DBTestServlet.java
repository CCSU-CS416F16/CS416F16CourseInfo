/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.db;

import edu.ccsu.beans.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "DBTestServlet", urlPatterns = {"/DBTestServlet"})
public class DBTestServlet extends HttpServlet {
    @Resource(name="jdbc/Lect16DB")
    private DataSource dataSource;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DBTestServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            
            Connection connection = dataSource.getConnection();
            String sql = "select * from person";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rSet = preparedStatement.executeQuery();
            while (rSet.next()){
                Person person = new Person();
                person.setFirstName(rSet.getString("firstName"));
                person.setLastName(rSet.getString("lastName"));
                person.setAge((Integer)rSet.getObject("age"));
                out.println(person.toString()+"<br/>");
            }
                
            out.println("</body>");
            out.println("</html>");
        }catch (Exception e){
            out.println("Error occurred");
            e.printStackTrace();
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
