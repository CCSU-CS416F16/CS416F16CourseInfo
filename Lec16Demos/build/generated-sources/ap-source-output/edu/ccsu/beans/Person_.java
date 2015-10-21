package edu.ccsu.beans;

import edu.ccsu.beans.Address;
import edu.ccsu.beans.Login;
import edu.ccsu.beans.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-28T10:54:44")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile SingularAttribute<Person, String> lastName;
    public static volatile SingularAttribute<Person, Integer> age;
    public static volatile SingularAttribute<Person, Login> login;
    public static volatile SingularAttribute<Person, String> firstName;
    public static volatile SetAttribute<Person, Address> addresses;
    public static volatile SetAttribute<Person, Phone> phones;

}