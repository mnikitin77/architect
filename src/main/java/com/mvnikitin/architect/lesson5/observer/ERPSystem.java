package com.mvnikitin.architect.lesson5.observer;

public class ERPSystem implements Observer{

    @Override
    public void update(Subject subject, Object arg) {
        if (arg instanceof Person) {
            System.out.println("ERP: Person [id: " + ((Person)arg).getId() + "] is updated");
        }
    }
}
