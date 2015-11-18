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
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
@WebServlet(name = "VoteServlet", urlPatterns = {"/VoteServlet"})
public class VoteServlet extends HttpServlet {

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
            String[] musicTypes = request.getParameterValues("musicType");
            if (musicTypes != null) {
                Set<String> musicTypesSet = new HashSet<String>(Arrays.asList(musicTypes));
                Connection connection = dataSource.getConnection();
                String selectSQL = "select * from VOTES";
                PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
                ResultSet musicTypeRecords = selectStatement.executeQuery();
                while (musicTypeRecords.next()) {
                    if (musicTypesSet.contains(musicTypeRecords.getString("MUSICTYPE"))) {
                        int numVotes = musicTypeRecords.getInt("NUMVOTES");
                        numVotes++;
                        String updateVoteSQL = "update VOTES set NUMVOTES = ? where MUSICTYPE = ?";
                        PreparedStatement updateStatement = connection.prepareStatement(updateVoteSQL);
                        updateStatement.setInt(1, numVotes);
                        updateStatement.setString(2, musicTypeRecords.getString("MUSICTYPE"));
                        updateStatement.executeUpdate();
                        updateStatement.close();
                    }
                }
                Integer curVotes = (Integer) request.getSession().getAttribute("sessionVotes");
                curVotes = curVotes == null ? 1 : curVotes + 1;
                request.getSession().setAttribute("sessionVotes", curVotes);
                musicTypeRecords.close();
                selectStatement.close();
                connection.close();
            }
            request.getRequestDispatcher("DisplayVotesServlet").forward(request, response);
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
