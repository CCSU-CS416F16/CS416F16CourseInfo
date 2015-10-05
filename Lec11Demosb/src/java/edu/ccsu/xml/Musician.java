package edu.ccsu.xml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chad Williams
 */
@XmlRootElement
public class Musician {

    private String first;
    private String last;
    
    public Musician(){};
    public Musician(String first, String last){
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    
    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}

@XmlRootElement
class Musicians {
    @XmlElement(name = "musician")
    public ArrayList<Musician> musicians = new ArrayList<Musician>();
}