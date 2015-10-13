package edu.ccsu.jpa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.ccsu.beans.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import javax.transaction.UserTransaction;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "JPAAddPerson", urlPatterns = {"/JPAAddPerson"})
public class JPAAddPerson extends HttpServlet {

    @Resource(name = "jdbc/Lect8aDB")
    private DataSource dataSource;
    @PersistenceUnit(unitName = "Lec15DemosPU")
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction userTransaction;

    protected int getNextId(String tableName) throws Exception {
        // Connect to database
        Connection connection = dataSource.getConnection();

        // Find the max person id to determine what the next person id should be
        String sql = "select max(id) from person";
        PreparedStatement maxIdSelect = connection.prepareStatement(sql);
        ResultSet results = maxIdSelect.executeQuery();
        results.next();
        int maxId = results.getInt(1);
        results.close();
        maxIdSelect.close();
        return maxId + 1;
    }

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
            Person newPerson = new Person();
            newPerson.setFirstName(request.getParameter("firstName"));
            newPerson.setLastName(request.getParameter("lastName"));
            int nextId = getNextId("Person");
            newPerson.setID(nextId);

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            userTransaction.begin();
            entityManager.persist(newPerson);
            userTransaction.commit();
            
            request.getRequestDispatcher("NamesLikeServlet").forward(request, response);
        } catch (Exception e) {
            out.println("Error occurred: " + e.getMessage());
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
