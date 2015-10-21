package edu.ccsu.beans;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Login implements Serializable{
    @Id
    private String id;
    private String password;
    
    // Remove foreign key attribute declaration
    // Integer personId;
    
    // Maps to foreign key column
    @OneToOne
    @JoinColumn(name="personid")
    private Person person;
    
    public Login(){
        
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }


}
