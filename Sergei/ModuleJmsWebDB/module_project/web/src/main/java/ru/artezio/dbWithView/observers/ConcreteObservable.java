package ru.artezio.dbWithView.observers;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObservable implements Observable {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers)
        {
            observer.update();
        }
    }

}
