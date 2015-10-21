/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author cw1491
 */
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue
    private Integer id = null;
    
    private String firstName = "";
    
    private String lastName = "";
    
    private Integer age = null;
    
    // Maps to the name the class is called on the Login class
    @OneToOne(mappedBy="person")
    private Login login;

    // Add the mapping to many addresses specifying the field
    // that maps back to this bean
    @OneToMany(mappedBy="person")
    private Set<Address> addresses;
    
    @ManyToMany(mappedBy="persons")
    private Set<Phone> phones;
    
    public Person() {
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public void setAge(String ageString){
        if (ageString!=null&&!ageString.equals("")){
            this.setAge(new Integer(ageString));
        }
    }
    

    public String toString() {
        return "Person(" + getFirstName() + " " + getLastName() + " age: " + getAge() + ")";
    }

    /**
     * @return the id
     */
    public Integer getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(Integer ID) {
        this.id = ID;
    }

    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * @return the addresses
     */
    public Set<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the phones
     */
    public Set<Phone> getPhones() {
        return phones;
    }

    /**
     * @param phones the phones to set
     */
    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

}
