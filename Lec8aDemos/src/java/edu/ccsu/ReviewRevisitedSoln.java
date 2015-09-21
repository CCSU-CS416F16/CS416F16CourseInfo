/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author cwilliam
 */
@WebServlet(name = "ReviewRevisitedSoln", urlPatterns = {"/ReviewRevisitedSoln"})
public class ReviewRevisitedSoln extends HttpServlet {

    @Resource(name = "jdbc/Lect8aDB")
    private DataSource datasource;

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
            Connection connection = datasource.getConnection();
            String name = request.getParameter("name");
            // If a name was entered add it to the database
            if (name != null && name.length() > 0) {
                int id = Integer.parseInt(request.getParameter("id"));
                String insertSQL = "insert into person (id,firstname) values (?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                insertStatement.setInt(1, id);
                insertStatement.setString(2, name);
                int recordsAffected = insertStatement.executeUpdate();
                insertStatement.close();
            }
            String deleteName = request.getParameter("deleteName");
            if (deleteName !=null && deleteName.length()>0){
                String deleteSQL = "delete from person where firstname = ?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL);
                deleteStatement.setString(1, deleteName);
                int recordsAffected = deleteStatement.executeUpdate();
                deleteStatement.close();
                
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReviewNamesSoln</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ReviewRevisitedSoln\" method=\"GET\">");
            out.println("Person id: <input type=\"textbox\" name=\"id\"/><br/>");
            out.println("Enter a name: <input type=\"textbox\" name=\"name\"/><br/>");
            out.println("<input type=\"submit\" value=\"Add name\"/>");
            out.println("</form>");
            out.println("<form action=\"ReviewRevisitedSoln\" method=\"POST\">");
            out.println("Enter a name to delete: <input type=\"textbox\" name=\"deleteName\"/><br/>");
            out.println("<input type=\"submit\" value=\"Delete name\"/>");
            out.println("</form>");
            out.println("Names:<br/>");
            out.println("<ul>");
            String readSQL = "select firstName from person";
            PreparedStatement readStatement = connection.prepareStatement(readSQL);
            ResultSet rs = readStatement.executeQuery();
            while (rs.next()) {
                name = rs.getString("firstname");
                out.println("<li>" + name + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
            rs.close();
            readStatement.close();
            connection.close();
        } catch (Exception e) {
            out.println("Exception occured " + e.getMessage());
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
