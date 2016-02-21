package ru.artezio.dbWithView.springhelpers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonContext {
    private SingletonContext() {
    }
    static private AbstractApplicationContext context;

    static public AbstractApplicationContext getInstance() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("spring-context.xml");
        }
        return context;
    }
}
