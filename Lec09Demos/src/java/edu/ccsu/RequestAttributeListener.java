/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author cw1491
 */
@WebListener()
public class RequestAttributeListener implements ServletRequestAttributeListener{

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        srae.getServletContext().log("Request Attribute created "+srae.getName()+"="+srae.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        srae.getServletContext().log("Request Attribute "+srae.getName()+" removed");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        srae.getServletContext().log("Request Attribute changed "+srae.getName()+"="+srae.getValue());
    }
    
}
