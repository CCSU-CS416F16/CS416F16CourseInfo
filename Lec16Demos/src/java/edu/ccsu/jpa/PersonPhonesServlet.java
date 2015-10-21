/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.jpa;

import edu.ccsu.beans.Person;
import edu.ccsu.beans.Phone;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "PersonPhonesServlet", urlPatterns = {"/PersonPhonesServlet"})
public class PersonPhonesServlet extends HttpServlet {
    @PersistenceUnit(unitName = "Lec16DemosPU")
    private EntityManagerFactory entityManagerFactory;
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
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            String queryString = "select p from Person p";
            Query query = entityManager.createQuery(queryString);
            List<Person> matchingPeople = query.getResultList();
            for (Person curPerson : matchingPeople) {
                out.println(curPerson.getFirstName()+" "+curPerson.getLastName()+" phones(");
                for (Phone curPhone : curPerson.getPhones()){
                    out.println(curPhone.getNumber()+" ");
                }
                out.println(")<br/>");
            }
            out.println("<hr/>");
            String phoneQueryString = "select ph from Phone ph";
            Query phoneQuery = entityManager.createQuery(phoneQueryString);
            List<Phone> matchingPhones = phoneQuery.getResultList();
            for (Phone curPhone : matchingPhones){
                out.println("phone num: "+curPhone.getNumber()+" phone type"+curPhone.getType()+" associated with (");
                for (Person curPerson : curPhone.getPersons()){
                    out.println("["+curPerson.getFirstName()+" "+curPerson.getLastName()+"]");
                }
                out.println(")<br/>");
            }

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
