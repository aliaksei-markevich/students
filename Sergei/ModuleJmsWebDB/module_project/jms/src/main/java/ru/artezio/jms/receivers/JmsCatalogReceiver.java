package ru.artezio.jms.receivers;

import javax.jms.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.jms.uploaders.FactoryMethodForUploaders;


public class JmsCatalogReceiver implements MessageListener {

    FactoryMethodForUploaders factoryMethodForUploaders;

    public FactoryMethodForUploaders getFactoryMethodForUploaders() {
        return factoryMethodForUploaders;
    }

    public void setFactoryMethodForUploaders(FactoryMethodForUploaders factoryMethodForUploaders) {
        this.factoryMethodForUploaders = factoryMethodForUploaders;
    }

    public void onMessage(Message message){
        System.out.println("CatalogReceiver work!!!!!!!!");
        try {
            byte[] data = new byte[(int) ((BytesMessage) message).getBodyLength()];
            ((BytesMessage) message).readBytes(data);
            System.out.println(message.getStringProperty("nameFile"));
            MultipartFile multipartFile = new MockMultipartFile("file", message.getStringProperty("nameFile"), message.getStringProperty("contentType"), data);
            factoryMethodForUploaders.getUploader(multipartFile).uploadFile(multipartFile);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
