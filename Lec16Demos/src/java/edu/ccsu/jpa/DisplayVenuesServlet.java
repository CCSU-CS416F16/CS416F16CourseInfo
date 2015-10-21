/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.jpa;

import edu.ccsu.beans.City;
import edu.ccsu.beans.Venue;
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
@WebServlet(name = "DisplayVenuesServlet", urlPatterns = {"/DisplayVenuesServlet"})
public class DisplayVenuesServlet extends HttpServlet {
    @PersistenceUnit(unitName = "Lec16DemosPU")
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
      String cityName = request.getParameter("city");
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      String selectSQL = "select c from City c";
      Query selectQuery = entityManager.createQuery(selectSQL);
      List<City> cities = selectQuery.getResultList();
      out.println("<h1>Retrieved by city</h1>");
      for (City curCity : cities){
          out.println("City name: "+curCity.getName()+" venues: ");
          for (Venue venue : curCity.getVenues()){
              out.println(venue.getName()+", ");
          }
          out.println("<br/>");
      }
      out.println("<h1>Retrieved by venue</h1>");
      String venueSQL = "select v from Venue v";
      Query venueQuery = entityManager.createQuery(venueSQL);
      List<Venue> venues = venueQuery.getResultList();
      for (Venue venue : venues){
          out.println("Venue name: "+venue.getName()+" city: "+venue.getCity().getName()+"<br/>");
      }
    }catch(Exception e){
      out.println(e.getMessage());
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
