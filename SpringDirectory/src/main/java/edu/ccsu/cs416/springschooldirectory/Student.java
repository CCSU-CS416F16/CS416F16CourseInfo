package edu.ccsu.cs416.springschooldirectory;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author Chad Williams
 */
@Entity
public class Student extends AbstractPersistable<Long>{
  private String firstname;
  private String lastname;
  private String phonenumber;
  @ManyToOne
  @JoinColumn(name="CID")
  private SchoolClass assignedClass;
  
  @Transient
  private Long newAssignedClassId;

  /**
   * @return the firstname
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * @param firstname the firstname to set
   */
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * @return the lastname
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * @param lastname the lastname to set
   */
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * @return the phonenumber
   */
  public String getPhonenumber() {
    return phonenumber;
  }

  /**
   * @param phonenumber the phonenumber to set
   */
  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  /**
   * @return the assignedClass
   */
  public SchoolClass getAssignedClass() {
    return assignedClass;
  }

  /**
   * @param assignedClass the assignedClass to set
   */
  public void setAssignedClass(SchoolClass assignedClass) {
    this.assignedClass = assignedClass;
  }

  /**
   * @return the newAssignedClassId
   */
  public Long getNewAssignedClassId() {
    return newAssignedClassId;
  }

  /**
   * @param newAssignedClassId the newAssignedClassId to set
   */
  public void setNewAssignedClassId(Long newAssignedClassId) {
    this.newAssignedClassId = newAssignedClassId;
  }
  
    @Override
  public String toString() {
    return String.format(
            "Student[id=%d, firstname='%s', lastname='%s', phonenumber='%s',assignedClass=%s]",
            getId(), firstname,lastname,phonenumber,assignedClass);
  }
}
