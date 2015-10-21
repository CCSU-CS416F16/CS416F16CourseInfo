/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author cw1491
 */
@Entity
@IdClass(value = EmailPK.class)
public class Email implements Serializable{
    @Id
    private String emailType;
    @Id
    private String address;
    public Email(){
        
    }

    /**
     * @return the emailType
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     * @param emailType the emailType to set
     */
    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
