package com.example.designpatterns.observer;

import java.util.Iterator;
import java.util.Vector;

public class Subject {
    private Vector<Observer> observers;

    public Subject() {
        observers = new Vector<>();
    }

    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()) {
            iterator.next().update();
        }
    }

    public void registerObserver(final Observer observer) {
        observers.add(observer);

    }
}
