package com.mvnikitin.architect.lesson4.proxy;

public interface PersonRepository {
    Person findPerson(String firstName,
                      String middleName,
                      String lastName,
                      String passport);
}
