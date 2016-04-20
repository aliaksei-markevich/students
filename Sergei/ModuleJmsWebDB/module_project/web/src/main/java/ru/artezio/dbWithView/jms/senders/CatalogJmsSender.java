package ru.artezio.dbWithView.jms.senders;

import javax.jms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CatalogJmsSender {

    @Autowired
    protected JmsTemplate jmsTemplate;

    public void sendMessages(MultipartFile file) throws JMSException {
        this.jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                BytesMessage message = session.createBytesMessage();
                byte[] byteArr = new byte[0];
                try {
                    byteArr = file.getBytes();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new JMSException("Ошибка в байтах потока");
                }
                message.writeBytes(byteArr);
                message.setStringProperty("nameFile", file.getOriginalFilename());
                message.setStringProperty("contentType", file.getContentType());
                return message;
            }
        });
    }
}

