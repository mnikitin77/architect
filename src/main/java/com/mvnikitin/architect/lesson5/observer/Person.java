package com.mvnikitin.architect.lesson5.observer;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    private static AtomicInteger idGenerator = new AtomicInteger(1);

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String passport;
    private String address;

    public Person(String firstName, String middleName, String lastName, String passport, String address) {
        id = idGenerator.getAndIncrement();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.passport = passport;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport='" + passport + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
