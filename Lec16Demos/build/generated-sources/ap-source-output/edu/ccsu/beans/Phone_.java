package edu.ccsu.beans;

import edu.ccsu.beans.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-28T10:54:44")
@StaticMetamodel(Phone.class)
public class Phone_ { 

    public static volatile SingularAttribute<Phone, String> number;
    public static volatile SingularAttribute<Phone, String> type;
    public static volatile SetAttribute<Phone, Person> persons;

}