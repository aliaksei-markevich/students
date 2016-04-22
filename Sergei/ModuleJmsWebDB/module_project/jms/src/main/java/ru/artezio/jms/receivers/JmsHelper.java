package ru.artezio.jms.receivers;

import javax.jms.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.BytesMessage;
import javax.jms.JMSException;

public class JmsHelper {
    static public MultipartFile convertMessageToMultipartFile(Message message) throws JMSException {
        byte[] data = new byte[(int) ((BytesMessage) message).getBodyLength()];
        ((BytesMessage) message).readBytes(data);
        MultipartFile multipartFile = new MockMultipartFile("file", message.getStringProperty("nameFile"), message.getStringProperty("contentType"), data);
        return multipartFile;
    }
}
