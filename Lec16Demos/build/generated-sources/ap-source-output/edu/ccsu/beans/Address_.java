package edu.ccsu.beans;

import edu.ccsu.beans.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-28T10:54:43")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, Person> person;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> zipcode;
    public static volatile SingularAttribute<Address, String> usState;
    public static volatile SingularAttribute<Address, String> city;

}