package edu.ccsu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@ManagedBean
@RequestScoped
@Entity
@Table(name = "USERS")
public class User implements Serializable {

  @Id
  private String username;

  private String password;

  @ManyToMany(mappedBy = "users")
  private Set<Group> groups = new HashSet();

  @Transient
  private String[] groupNames;

  public User() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the groups
   */
  public String[] getGroupNames() {
    return groupNames;
  }

  /**
   * @param groups the groups to set
   */
  public void setGroupNames(String[] groupNames) {
    this.groupNames = groupNames;
  }

  /**
   * @return the groups
   */
  public Set<Group> getGroups() {
    return groups;
  }

  /**
   * @param groups the groups to set
   */
  public void setGroups(Set<Group> groups) {
    this.groups = groups;
  }

}
