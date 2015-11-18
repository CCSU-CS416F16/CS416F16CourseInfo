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
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "CreateMusicTypeServlet", urlPatterns = {"/CreateMusicTypeServlet"})
public class CreateMusicTypeServlet extends HttpServlet {

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
            String newMusicType = request.getParameter("newMusicType");
            if (newMusicType == null || newMusicType.trim().length() == 0) {
                out.println("A valid music type name was not entered");
            } else {
                Connection connection = dataSource.getConnection();
                String insertSQL = "insert into VOTES (MUSICTYPE,NUMVOTES) values (?,?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
                insertStatement.setString(1, newMusicType);
                insertStatement.setInt(2, 1);
                int updatedRecords = insertStatement.executeUpdate();
                if (updatedRecords==1){
                    Integer curVotes = (Integer)request.getSession().getAttribute("sessionVotes");
                    curVotes = curVotes==null?1:curVotes+1;
                    request.getSession().setAttribute("sessionVotes", curVotes);
                    request.getRequestDispatcher("DisplayVotesServlet").forward(request, response);
                }else{
                    out.println("Something went wrong with creating the music type");
                }
                insertStatement.close();
                connection.close();
            }
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
