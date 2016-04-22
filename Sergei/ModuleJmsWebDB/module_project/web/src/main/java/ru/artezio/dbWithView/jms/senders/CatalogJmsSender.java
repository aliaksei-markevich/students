package ru.artezio.dbWithView.jms.senders;

import javax.jms.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CatalogJmsSender {

    @Autowired
    protected JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("convertDestination")
    protected Destination convertDestination;

    @Autowired
    @Qualifier("importDestination")
    protected Destination importDestination;

    public void sendMessages(MultipartFile file, String isConvert){

        if (!isConvert.isEmpty()) {
            this.jmsTemplate.setDefaultDestination(convertDestination);
        } else {
            this.jmsTemplate.setDefaultDestination(importDestination);
        }

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
                if (!isConvert.isEmpty()) {
                    message.setStringProperty("pathFile", isConvert);
                }
                message.setStringProperty("nameFile", file.getOriginalFilename());
                return message;
            }
        });
    }
}

