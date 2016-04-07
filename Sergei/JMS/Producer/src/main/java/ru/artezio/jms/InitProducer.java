package ru.artezio.jms;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;


public class InitProducer {
    public static void main(String[] args) {
        try {
			org.apache.log4j.BasicConfigurator.configure();
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,ActiveMQConnectionFactory.DEFAULT_PASSWORD,"failover://tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("TEST.FOO");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            String text = "Hello world!";
            TextMessage message = session.createTextMessage(text);
            System.out.println("Sent message: " + message.getText());
            producer.send(message);
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}

