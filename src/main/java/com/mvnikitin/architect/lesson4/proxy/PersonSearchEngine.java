package com.mvnikitin.architect.lesson4.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonSearchEngine implements PersonRepository{

    private static final int CACHE_SIZE = 10;

    Map<String, Person> personsCache = new HashMap<>();
    PersonRepository personRepository = new PersonRepositoryImpl();

    @Override
    public Person findPerson(String firstName,
                             String middleName,
                             String lastName,
                             String passport) {

        Person person = personsCache.get(
                firstName + middleName + lastName + passport);

        if (person == null) {
            person = personRepository.findPerson(
                    firstName, middleName, lastName, passport);
            System.out.println("...found in database");

            addPersonToCache(person);
            System.out.println("...added to cache");
        } else {
            System.out.println("...found in cache");
        }

        return person;
    }

    private void addPersonToCache(Person person) {

        // Shrink the cache if exceeds
        checkCacheSize();
        personsCache.put(
                person.getFirstName() + person.getMiddleName() +
                        person.getLastName() + person.getPassport(),
                person);
    }

    private void checkCacheSize() {

        if (personsCache.size() >= CACHE_SIZE) {

            Set<Map.Entry<String, Person>> entriesToHold =
                    personsCache.entrySet().stream()
                            .limit(CACHE_SIZE - 1)
                            .collect(Collectors.toSet());

            personsCache = new HashMap<>(CACHE_SIZE);

            for (Map.Entry<String, Person> e: entriesToHold) {
                personsCache.put(e.getKey(), e.getValue());
            }

            System.out.println("The cache is shrinked");
        }
    }
}
