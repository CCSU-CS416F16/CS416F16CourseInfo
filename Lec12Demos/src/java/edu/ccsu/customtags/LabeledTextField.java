/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.customtags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author cw1491
 */
public class LabeledTextField extends SimpleTagSupport {
    private String label = "";
    private String name = "";
    private String value = "";

    /**
     * Called by the container to invoke this tag. 
     * The implementation of this method is provided by the tag library developer,
     * and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            out.println("<tr><th>"+label+
                    "</th><td><input type=\"text\" name=\""+name+
                    "\" value=\""+value+"\"/></td></tr>");
            

        } catch (java.io.IOException ex) {
            throw new JspException("Error in LabeledTextField tag", ex);
        }
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
