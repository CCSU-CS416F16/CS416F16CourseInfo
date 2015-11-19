/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cw1491
 */
@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String emailAddress = (String)value;
        HtmlInputText htmlInputText = (HtmlInputText)component;
        if (!emailAddress.matches("[A-Za-z0-9]+@[A-Za-z0-9]+.[A-Za-z0-9]+")){
            FacesMessage facesMessage =  new FacesMessage(htmlInputText.getLabel()+": email format is not valid");
            throw new ValidatorException(facesMessage);
        }
    }
}
