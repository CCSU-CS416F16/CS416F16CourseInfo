/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

/**
 *
 * @author cw1491
 */
public class BeanCounter {
    private int numberOfBeans;
    public BeanCounter(){
        
    }

    /**
     * @return the numberOfBeans
     */
    public int getNumberOfBeans() {
        return numberOfBeans;
    }

    /**
     * @param numberOfBeans the numberOfBeans to set
     */
    public void setNumberOfBeans(int numberOfBeans) {
        this.numberOfBeans += numberOfBeans;
    }

}
