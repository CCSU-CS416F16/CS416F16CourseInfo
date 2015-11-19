/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.validators;

import java.util.HashSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cw1491
 */
@ManagedBean
public class ValidationUtils {

    private HashSet states = new HashSet();
    private HashSet zipCodes = new HashSet();

    public ValidationUtils() {
        states.add("CT");
        states.add("NY");
        states.add("NJ");
        zipCodes.add("06030");
        zipCodes.add("06032");
    }

    /**
     * Validates that the passed field only contains alphabetic characters and spaces
     * @param context
     * @param component
     * @param value
     * @throws ValidatorException 
     */
    public void validateAlphaSpace(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String valueString = (String) value;
        if (!valueString.matches("[a-zA-Z ]+")) {
            HtmlInputText htmlInputText = (HtmlInputText) component;
            FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + ": only alphabetic and space characters are allowed.");
            throw new ValidatorException(facesMessage);
        }
    }

    public void validateState(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String valueString = (String) value;
        if (!states.contains(valueString)) {
            HtmlInputText htmlInputText = (HtmlInputText) component;
            FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + ": Not state abbreviation");
            throw new ValidatorException(facesMessage);

        }
    }


    /**
     * @return the states
     */
    public HashSet getStates() {
        return states;
    }

    /**
     * @param states the states to set
     */
    public void setStates(HashSet states) {
        this.states = states;
    }

    /**
     * @return the zipCodes
     */
    public HashSet getZipCodes() {
        return zipCodes;
    }

    /**
     * @param zipCodes the zipCodes to set
     */
    public void setZipCodes(HashSet zipCodes) {
        this.zipCodes = zipCodes;
    }
}
