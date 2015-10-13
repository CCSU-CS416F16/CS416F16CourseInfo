package edu.ccsu.beans;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author cw1491
 */
@Entity
public class Pet implements Serializable {

  @Id
  @GeneratedValue
  private Integer ID = null;
  private String name = null;
  private String type = null;
  private Integer age = null;

  public Pet() {
  }

  /**
   * @return the ID
   */
  public Integer getID() {
    return ID;
  }

  /**
   * @param ID the ID to set
   */
  public void setID(Integer ID) {
    this.ID = ID;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
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

}
