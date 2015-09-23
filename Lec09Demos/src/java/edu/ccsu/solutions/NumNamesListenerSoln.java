/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.solutions;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author cw1491
 */
@WebListener()
public class NumNamesListenerSoln implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        if (event.getName().equals("numNamesSoln")) {
            event.getServletContext().setAttribute("timeLastChange", new Long(System.nanoTime()));
        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        // do nothing
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        if (event.getName().equals("numNamesSoln")) {
            long curTime = System.nanoTime();
            long lastTime = ((Long)event.getServletContext().getAttribute("timeLastChange")).longValue();
            long timeSinceChange = curTime - lastTime;
            event.getServletContext().log("Time since numNamesSoln changed: "+timeSinceChange);
            event.getServletContext().setAttribute("timeLastChange", new Long(curTime));
        }
    }
}
