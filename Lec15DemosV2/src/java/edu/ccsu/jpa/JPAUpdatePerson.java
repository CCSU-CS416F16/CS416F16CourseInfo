/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.jpa;

import edu.ccsu.beans.Person;
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
@WebServlet(name = "JPAUpdatePerson", urlPatterns = {"/JPAUpdatePerson"})
public class JPAUpdatePerson extends HttpServlet {

  @PersistenceUnit(unitName = "Lec15DemosPU")
  private EntityManagerFactory entityManagerFactory;


  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
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
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String newLastName = request.getParameter("newLastName");
      entityManager.getTransaction().begin();
      String queryString = "Select p from Person p where p.firstName = :firstName and p.lastName = :lastName";
      Query query = entityManager.createQuery(queryString);
      query.setParameter("firstName", firstName);
      query.setParameter("lastName", lastName);
      List matchingPeople = query.getResultList();
      for (int i = 0; i < matchingPeople.size(); i++) {
        Person p = (Person) matchingPeople.get(i);
        p.setLastName(newLastName);
        entityManager.persist(p);
      }
      entityManager.getTransaction().commit();
      request.getRequestDispatcher("NamesLikeServlet").forward(request, response);
    } catch (Exception e) {
      out.println("Exception occurred: " + e.getMessage());
      e.printStackTrace();
    } finally {
      out.close();
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
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
   * Handles the HTTP
   * <code>POST</code> method.
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
