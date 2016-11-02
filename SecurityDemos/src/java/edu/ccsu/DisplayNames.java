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
@WebServlet(name = "DisplayNames", urlPatterns = {"/DisplayNames", "/index.jsp"})
public class DisplayNames extends HttpServlet {

    @Resource(name = "jdbc/Lect8aDB")
    private DataSource dataSource;

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayNames</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p style=\"color:red\">Susceptible to XSS</p>");
            Connection connection = dataSource.getConnection();
            String selectSQL = "select * from person";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                out.println(resultSet.getString("id") + ": " + resultSet.getString("firstName") + " " + resultSet.getString("lastName") + "<br/>");
            }
            out.println("<a href=\"DisplayNames\">display names</a> | ");
            out.println("<a href=\"AddPerson.html\">Add person</a> | ");
            out.println("<a href=\"UpdatePerson.html\">Update person</a> | ");
            out.println("<a href=\"DeletePerson.html\">Delete person</a> ");
            resultSet.close();
            selectStatement.close();
            connection.close();
            out.println("<hr/><h3>Enter your billing info</h3>");
            out.println("credit card <input type=\"text\"/>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            out.println("Exception occurred " + e.getMessage());
            e.printStackTrace();
        } finally {
            out.close();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
