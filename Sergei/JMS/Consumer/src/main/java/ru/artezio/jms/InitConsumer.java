package ru.artezio.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class InitConsumer {
    public static void main(String[] args) {
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "failover://tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("TEST.FOO");
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive(1000);
            while (message != null) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("Received: " + text);
                System.out.println("JMSMessageID: " + message.getJMSMessageID());
                System.out.println("JMSDestination: " + message.getJMSDestination());
                System.out.println("JMSExpiration: " + message.getJMSExpiration());
                System.out.println("JMSPriority: " + message.getJMSPriority());
                message = consumer.receive(1000);
            }

            consumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
