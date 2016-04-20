package ru.artezio.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context-jms.xml");
        try {
            Thread.sleep(10000000);
        } finally {
            context.close();
        }
    }
}
