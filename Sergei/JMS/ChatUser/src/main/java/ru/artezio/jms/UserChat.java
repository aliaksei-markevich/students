package ru.artezio.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class UserChat implements MessageListener {

    public UserChat() {
    }

    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.getText());
        } catch (JMSException jmse) {
            jmse.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // org.apache.log4j.BasicConfigurator.configure();
        try {
            System.out.println(args[0]);
            Scanner sc = new Scanner(System.in);
            String message = "";
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "failover://tcp://localhost:61616");
            Connection connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic("TEST.FOO");
            MessageConsumer consumer = session.createConsumer(destination);
            MessageProducer producer = session.createProducer(destination);
            UserChat async = new UserChat();
            consumer.setMessageListener(async);
            while (!message.equals("exit")) {
                message = sc.nextLine();
                TextMessage textMessage = session.createTextMessage(args[0] + ": " + message);
                producer.send(textMessage);
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
