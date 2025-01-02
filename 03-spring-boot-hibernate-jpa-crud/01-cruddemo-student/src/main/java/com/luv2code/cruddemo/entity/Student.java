package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    //define fields
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="email")
    private String email;



    //define constructors
    public Student(){

    }

    public Student(String lastName, String email, String firstName) {
        this.lastName = lastName;
        this.email = email;
        this.firstName = firstName;

    }


    //define getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //define toStrind() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
