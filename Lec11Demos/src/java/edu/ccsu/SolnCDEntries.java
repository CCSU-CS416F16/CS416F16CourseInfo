/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

/**
 *
 * @author cw1491
 */
public class SolnCDEntries {
    private Double ratings;
    private Integer numRatings;

    public SolnCDEntries(){
        ratings=new Double(0);
        numRatings = new Integer(0);
    }

    /**
     * @return the ratings
     */
    public Double getRatings() {
        return ratings;
    }

    /**
     * @param ratings the ratings to set
     */
    public void setRatings(Double ratings) {
        this.ratings += ratings;
        numRatings++;
    }

    /**
     * @return the numRatings
     */
    public Integer getNumRatings() {
        return numRatings;
    }

    /**
     * @param numRatings the numRatings to set
     */
    public void setNumRatings(Integer numRatings) {
        this.numRatings = numRatings;
    }
    
    public double getAverageRatings(){
        return this.ratings / this.numRatings;
    }
}
