package edu.ccsu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@ManagedBean
@RequestScoped
@Entity
@Table(name = "GROUPS")
public class Group implements Serializable {
    @Id
    private String groupName;
    
    private String groupDescription;
    
    @ManyToMany
    @JoinTable(name="USER_GROUPS", 
            joinColumns=@JoinColumn(name="GROUPNAME",referencedColumnName="groupName"),
            inverseJoinColumns=@JoinColumn(name="USERNAME",referencedColumnName="username"))
    private Set<User> users = new HashSet();

    public Group(){
        
    }


    public String getGroupName(){
        return groupName;
    }
    
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

  /**
   * @return the users
   */
  public Set<User> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(Set<User> users) {
    this.users = users;
  }
    
}
