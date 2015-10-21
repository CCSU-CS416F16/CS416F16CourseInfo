/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author cw1491
 */
@Entity
public class City implements Serializable {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String usState;
  private int population;
  
  @OneToMany(mappedBy="city")
  private Set<Venue> venues = new HashSet();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof City)) {
      return false;
    }
    City other = (City) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "edu.ccsu.beans.City[ id=" + id + " ]";
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
   * @return the population
   */
  public int getPopulation() {
    return population;
  }

  /**
   * @param population the population to set
   */
  public void setPopulation(int population) {
    this.population = population;
  }

    /**
     * @return the usState
     */
    public String getUsState() {
        return usState;
    }

    /**
     * @param usState the usState to set
     */
    public void setUsState(String usState) {
        this.usState = usState;
    }

    /**
     * @return the venues
     */
    public Set<Venue> getVenues() {
        return venues;
    }

    /**
     * @param venues the venues to set
     */
    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }
  
}
