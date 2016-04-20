package ru.artezio.dbWithView.observers;

public class ConcreteObserverXSL implements Observer {
    @Override
    public void update() {
        System.out.println("Обновление XSL");
    }
}
