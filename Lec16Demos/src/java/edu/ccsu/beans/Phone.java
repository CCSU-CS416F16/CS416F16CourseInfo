/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author cw1491
 */
@Entity
public class Phone implements Serializable{
    @Id
    private String number;
    private String type = "";
    
    @ManyToMany
    @JoinTable(name="PersonPhone", 
            joinColumns=@JoinColumn(name="phoneId",referencedColumnName="number"),
            inverseJoinColumns=@JoinColumn(name="personId",referencedColumnName="id"))
    private Set<Person> persons = new HashSet();
        
        public Phone(){
            
        }


    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the persons
     */
    public Set<Person> getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
