/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.beans;

import java.io.Serializable;

/**
 *
 * @author cw1491
 */
public class EmailPK implements Serializable{
    private String emailType;
    private String address;
    public EmailPK(){
        
    }
    
    public EmailPK(String emailType, String address){
        this.emailType = emailType;
        this.address = address;
    }
    
    public boolean equals(Object obj){
        return obj.toString().equals(toString());
    }
    
    public int hashCode(){
        return toString().hashCode();
    }
    
    public String toString(){
        return emailType+"-"+address;
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
