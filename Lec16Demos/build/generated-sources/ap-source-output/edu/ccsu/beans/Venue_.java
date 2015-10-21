package edu.ccsu.beans;

import edu.ccsu.beans.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-28T10:54:44")
@StaticMetamodel(Venue.class)
public class Venue_ { 

    public static volatile SingularAttribute<Venue, Long> id;
    public static volatile SingularAttribute<Venue, String> name;
    public static volatile SingularAttribute<Venue, City> city;

}