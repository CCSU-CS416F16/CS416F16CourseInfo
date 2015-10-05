package edu.ccsu.xml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chad Williams
 */
@XmlRootElement
public class CD {
    private String artist;
    private String title;
    private Integer year;
    private Musicians musicians = new Musicians();

    public CD(){}
    public CD(String artist, String title, Integer year){
        this.artist = artist;
        this.title = title;
        this.year = year;
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
     * @return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * @return the musicians
     */
    public Musicians getMusicians() {
        return musicians;
    }

    /**
     * @param musicians the musicians to set
     */
    public void setMusicians(Musicians musicians) {
        this.musicians = musicians;
    }
    
    public void addMusician(Musician musician){
        this.musicians.musicians.add(musician);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
}

@XmlRootElement
class CDs {
    @XmlElement(name = "CD")
    public ArrayList<CD> cdList = new ArrayList<CD>();
}