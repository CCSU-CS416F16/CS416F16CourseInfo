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
import javax.sql.DataSource;


@WebServlet(name = "StartPageServlet", urlPatterns = {"/StartPageServlet"})
public class StartPageServlet extends HttpServlet {

    @Resource(name = "jdbc/HW2DB")
    DataSource dataSource;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StartPageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form name=\"voteSubmission\" action=\"VoteServlet\" method=\"POST\">");
            out.println("<h2>Vote for your favorite types of music:</h2>");
            Connection connection = dataSource.getConnection();
            String selectSQL = "select MUSICTYPE from VOTES";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String musicType = resultSet.getString("MUSICTYPE");
                out.println(musicType + "<input type=\"checkbox\" name=\"musicType\" value=\"" + musicType + "\"/><br/>");
            }
            out.println("<input type=\"submit\" value=\"Submit votes\" /><br/>");
            out.println("</form>");

            out.println("<h2>Or add a new one:</h2>");
            out.println("<form name=\"createMusic\" action=\"CreateMusicTypeServlet\" method=\"POST\">");
            out.println("New music type <input type=\"text\" name=\"newMusicType\" /><br/>");
            out.println("<input type=\"submit\" value=\"Add music type and vote\" /><br/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (Exception e) {
            out.println("Had a problem getting the music types from the database " + e.getMessage());
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
