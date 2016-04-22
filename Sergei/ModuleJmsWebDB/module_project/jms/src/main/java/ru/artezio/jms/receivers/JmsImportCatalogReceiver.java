package ru.artezio.jms.receivers;

import javax.jms.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.jms.uploaders.FactoryMethodForUploaders;

@Component("messageListenerImportFile")
public class JmsImportCatalogReceiver implements MessageListener {

    @Autowired
    FactoryMethodForUploaders factoryMethodForUploaders;

    public void onMessage(Message message) {
        try {
            MultipartFile multipartFile = JmsHelper.convertMessageToMultipartFile(message);
            factoryMethodForUploaders.getUploader(multipartFile).uploadFile(multipartFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
