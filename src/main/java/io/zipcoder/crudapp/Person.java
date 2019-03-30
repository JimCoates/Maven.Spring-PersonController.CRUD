package io.zipcoder.crudapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Person {
    String firstName;

    String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idNumber;

    public Person(){}

    public Person(String fname, String lname) {this(null, fname,lname);}

    public Person(Long id, String fname, String lname) {
        this.idNumber = id;
        this.firstName = fname;
        this.lastName = lname;
    }
}
