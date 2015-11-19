/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ManagedBean
@SessionScoped
@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private Long carId;
    private String ownerEmail = "";
    private String make = "";
    private String model = "";
    private String stateOwned = "";
    private Long numberOfMiles = new Long(0);
    private String zipCode = "";
    private Long newMiles = new Long(0);
    private boolean emmissionsCheck = false;
    private boolean jointOwnership = false;

    public Car() {
    }

    public void addMileage(ActionEvent event) {
        numberOfMiles = numberOfMiles + getNewMiles();
    }

    /**
     * @return the carId
     */
    public Long getCarId() {
        return carId;
    }

    /**
     * @param carId the carId to set
     */
    public void setCarId(Long carId) {
        this.carId = carId;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the stateOwned
     */
    public String getStateOwned() {
        return stateOwned;
    }

    /**
     * @param stateOwned the stateOwned to set
     */
    public void setStateOwned(String stateOwned) {
        this.stateOwned = stateOwned;
    }

    /**
     * @return the numberOfMiles
     */
    public Long getNumberOfMiles() {
        return numberOfMiles;
    }

    /**
     * @param numberOfMiles the numberOfMiles to set
     */
    public void setNumberOfMiles(Long numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the newMiles
     */
    public Long getNewMiles() {
        return newMiles;
    }

    /**
     * @param newMiles the newMiles to set
     */
    public void setNewMiles(Long newMiles) {
        this.newMiles = newMiles;
    }

    /**
     * @return the ownerEmail
     */
    public String getOwnerEmail() {
        return ownerEmail==null?"":ownerEmail;
    }

    /**
     * @param ownerEmail the ownerEmail to set
     */
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    /**
     * @return the emmissionsCheck
     */
    public boolean isEmmissionsCheck() {
        return emmissionsCheck;
    }

    /**
     * @param emmissionsCheck the emmissionsCheck to set
     */
    public void setEmmissionsCheck(boolean emmissionsCheck) {
        this.emmissionsCheck = emmissionsCheck;
    }

    /**
     * @return the jointOwnership
     */
    public boolean isJointOwnership() {
        return jointOwnership;
    }

    /**
     * @param jointOwnership the jointOwnership to set
     */
    public void setJointOwnership(boolean jointOwnership) {
        this.jointOwnership = jointOwnership;
    }

    public ArrayList<SelectItem> getStateList() {
        ArrayList<SelectItem> stateList = new ArrayList();
        stateList.add(new SelectItem(null, "Select One…"));
        stateList.add(new SelectItem("CA", "California"));
        stateList.add(new SelectItem("NY", "New York"));
        stateList.add(new SelectItem("Other", "Other"));
        return stateList;
    }

    public String specialRules() {
        // Only need to check joint ownership paperwork on first car
        if ((getStateOwned().equals("CA") || getStateOwned().equals("NY"))
                && (!isJointOwnership())) {
            return "jointOwnership";
        }
        if (getStateOwned().equals("CA") && (!isEmmissionsCheck())) {
            return "emissions";
        }
        return "none";
    }
    
    public String valid(){
        if (specialRules().equals("none")){
            return "valid";
        }else{
            return "invalid";
        }
    }
}
