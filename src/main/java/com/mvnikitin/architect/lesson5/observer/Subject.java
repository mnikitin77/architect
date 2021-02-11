package com.mvnikitin.architect.lesson5.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notify(Object arg) {
        for (Observer o: observers) {
            o.update(this, arg);
        }
    }
}
