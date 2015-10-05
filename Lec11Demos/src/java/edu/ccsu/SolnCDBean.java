/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

/**
 *
 * @author cw1491
 */
public class SolnCDBean implements java.io.Serializable{
    private String artist;
    private String title;
    private Integer rating;
    
    public SolnCDBean(){
        
    }

    /**
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @param artist the artist to set
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return the name
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param name the name to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
            
}
