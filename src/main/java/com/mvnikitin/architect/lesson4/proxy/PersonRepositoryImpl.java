package com.mvnikitin.architect.lesson4.proxy;

public class PersonRepositoryImpl implements PersonRepository{

    @Override
    public Person findPerson(String firstName,
                             String middleName,
                             String lastName,
                             String passport) {

        return new Person(firstName, middleName, lastName, passport);
    }
}
