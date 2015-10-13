/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.solns;

import java.io.Serializable;

/**
 *
 * @author cw1491
 */
public class Item implements Serializable{
    private String itemName ="";
    private Double itemCost = 0.0;
    public Item(){
        
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemCost
     */
    public Double getItemCost() {
        return itemCost;
    }

    /**
     * @param itemCost the itemCost to set
     */
    public void setItemCost(Double itemCost) {
        this.itemCost = itemCost;
    }
}
