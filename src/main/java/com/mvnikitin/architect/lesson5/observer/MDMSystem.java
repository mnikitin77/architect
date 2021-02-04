package com.mvnikitin.architect.lesson5.observer;

import java.util.ArrayList;
import java.util.List;

public class MDMSystem {

    private static List<Person> personDB = new ArrayList<>();
    static {
        personDB.add(new Person("Иван", "Иванович", "Иванов", "4205 321654", "Россия, Москва, Тверская 11, кв. 39"));
        personDB.add(new Person("J.J.", "", "McQuade", "1234 321654", "USA, TX, El Paso, rancho #12345"));
        personDB.add(new Person("Joaquin", "", "Guzman Loera", "5000 000001", "Mexico, Sinaloa, Culiacan, casa de seguridad #1"));
    }

    public static void main(String[] args) {
//        init the systems
        Subject personPublisher = new PersonPublisher();
        personPublisher.attach(new CRMSystem());
        personPublisher.attach(new ERPSystem());

        // Updating persons
        personDB.get(2).setMiddleName("\"El Chapo\"");
        personPublisher.notify(personDB.get(2));
    }
}
