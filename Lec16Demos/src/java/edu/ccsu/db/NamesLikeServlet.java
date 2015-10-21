/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.db;

import edu.ccsu.beans.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
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
@WebServlet(name = "NamesLikeServlet", urlPatterns = {"/NamesLikeServlet"})
public class NamesLikeServlet extends HttpServlet {

    @Resource(name = "jdbc/Lect16DB")
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
        ArrayList personList = new ArrayList();
        String sql = "select * from PERSON where firstname like ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String queryParam = request.getParameter("name");
            if (queryParam == null) {
                queryParam = "";
            }
            queryParam += "%";
            preparedStatement.setString(1, queryParam);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Person curPerson = new Person();
                curPerson.setFirstName(resultSet.getString("firstName"));
                curPerson.setLastName(resultSet.getString("lastName"));
                curPerson.setAge((Integer) resultSet.getObject("age"));
                personList.add(curPerson);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            request.setAttribute("personList", personList);
            request.getRequestDispatcher("PersonDisplay.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error occurred");
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
