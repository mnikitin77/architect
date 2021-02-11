package com.mvnikitin.architect.lesson5.observer;

public class CRMSystem implements Observer{

    @Override
    public void update(Subject subject, Object arg) {
        if (arg instanceof Person) {
            System.out.println("CRM: Person [id: " + ((Person)arg).getId() + "] is updated, " + (Person)arg);
        }
    }
}
