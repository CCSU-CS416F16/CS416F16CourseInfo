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
public class ValidationUtilsSoln {

    private HashSet states = new HashSet();
    private HashSet zipCodes = new HashSet();

    public ValidationUtilsSoln() {
        zipCodes.add("06030");
        zipCodes.add("06032");
    }

    public void validateZipCode(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String valueString = (String) value;
        if (!zipCodes.contains(valueString)) {
            HtmlInputText htmlInputText = (HtmlInputText) component;
            FacesMessage facesMessage = new FacesMessage(htmlInputText.getLabel() + ": Not one of the allowed zip codes");
            throw new ValidatorException(facesMessage);

        }
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
