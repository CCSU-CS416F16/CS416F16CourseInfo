/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.solutions;

import edu.ccsu.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "PerformanceFilterSoln", urlPatterns = {"/ReviewPersistingSolnServlet"})
public class PerformanceFilterSoln implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.nanoTime();
        chain.doFilter(request, response);
        long stopTime = System.nanoTime();
        request.getServletContext().log("********** Runtime:"+(stopTime - startTime)+" *************");
    }

    @Override
    public void destroy() {
        // do nothing
    }
    
}
