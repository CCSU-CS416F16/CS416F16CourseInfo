/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

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

@WebFilter(filterName = "LoggingFilter", urlPatterns = {"/ReviewPersistingSolnServlet"})
public class LoggingFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        //**********************
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        //**********************
        context.log("*** Entering Servlet ***");
        context.log("*** request name="+request.getParameter("fullname")+" ***");
        context.log("*** session name="+httpRequest.getSession().getAttribute("nameSoln") +" ***");
        context.log("*** context Num Names="+request.getServletContext().getAttribute("numNamesSoln")+" ***");
        request.setAttribute("filterAttr1", "value1");
        httpRequest.getSession().setAttribute("filterAttr2","value2");
        
        chain.doFilter(request, response);
        context.log("@@@ request name="+request.getParameter("fullname")+" @@@");
        context.log("@@@ session name="+httpRequest.getSession().getAttribute("nameSoln") +" @@@");
        context.log("@@@ context Num Names="+request.getServletContext().getAttribute("numNamesSoln")+" @@@");
        context.log("*** Exiting Servlet ***");
        httpRequest.getSession().getAttribute("filterAttr2");
        // Do some processing on value
        httpRequest.getSession().removeAttribute("filterAttr2");
        request.setAttribute("filterAttr1", "value2");
        request.removeAttribute("filterAttr1");
    }

    @Override
    public void destroy() {
        // do nothing
    }
    
}
