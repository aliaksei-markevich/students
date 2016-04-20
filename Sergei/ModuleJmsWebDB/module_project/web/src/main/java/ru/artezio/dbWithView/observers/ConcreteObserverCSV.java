package ru.artezio.dbWithView.observers;

public class ConcreteObserverCSV implements Observer {
    @Override
    public void update() {
        System.out.println("Обновление CSV");
    }
}
