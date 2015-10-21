package edu.ccsu.beans;

import edu.ccsu.beans.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-10-28T10:54:43")
@StaticMetamodel(Login.class)
public class Login_ { 

    public static volatile SingularAttribute<Login, String> id;
    public static volatile SingularAttribute<Login, Person> person;
    public static volatile SingularAttribute<Login, String> password;

}