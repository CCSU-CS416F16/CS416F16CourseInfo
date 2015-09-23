/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.protectedpage;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This filter protects all pages with the extension ".jsp"
 * If a jsp is requested this page first checks to see if the user is
 * authenticated and if not redirects them to the authentication page
 * 
 */
@WebFilter(filterName = "AuthorizationFilter", urlPatterns = {"*.jsp"})
public class AuthorizationFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        HttpServletRequest servRequest =(HttpServletRequest)request;
        HttpSession session = servRequest.getSession();
        boolean authorized = session.getAttribute("authorized")!=null;
        // check to see if they provided login credentials
        if (!authorized && (request.getParameter("loginId")!=null)&& (request.getParameter("password")!=null)){
            // Check creditials
            if (request.getParameter("loginId").equals("chad")&& request.getParameter("password").equals("chad")){
                session.setAttribute("authorized", new Boolean(true));
                authorized=true;
            }else{
                request.setAttribute("badPassword", "");
            }
        }
        // if authorized
        if (authorized){
            chain.doFilter(request, response);
        }else{
            request.setAttribute("targetPage", servRequest.getRequestURI());
            request.getRequestDispatcher("AuthorizationServlet").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }
    
}
