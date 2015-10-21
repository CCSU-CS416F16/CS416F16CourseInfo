package edu.ccsu.beans;

import edu.ccsu.beans.Venue;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-28T10:54:44")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, Long> id;
    public static volatile SingularAttribute<City, String> name;
    public static volatile SetAttribute<City, Venue> venues;
    public static volatile SingularAttribute<City, String> usState;
    public static volatile SingularAttribute<City, Integer> population;

}