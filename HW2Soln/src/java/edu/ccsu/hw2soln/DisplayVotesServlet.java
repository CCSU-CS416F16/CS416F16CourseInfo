/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.hw2soln;

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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * This servlet just displays the vote data
 */
@WebServlet(name = "DisplayVotesServlet", urlPatterns = {"/DisplayVotesServlet"})
public class DisplayVotesServlet extends HttpServlet {

    @Resource(name = "jdbc/HW2DB")
    DataSource dataSource;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Display votes</title>");
            out.println("</head>");
            out.println("<body>");

            Connection connection = dataSource.getConnection();
            String selectSQL = "select * from VOTES";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String musicType = resultSet.getString("MUSICTYPE");
                int numVotes = resultSet.getInt("NUMVOTES");
                out.println(musicType + " has " + numVotes + " votes<br/>");
            }
            Integer curVotes = (Integer) request.getSession().getAttribute("sessionVotes");
            if (curVotes!=null){
                out.println("You have voted "+curVotes+" times");
            }else{
                out.println("You have not voted yet");
            }
            out.println("</body>");
            out.println("</html>");
            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (Exception e) {
            out.println("Had a problem getting the vote data from the database " + e.getMessage());
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
