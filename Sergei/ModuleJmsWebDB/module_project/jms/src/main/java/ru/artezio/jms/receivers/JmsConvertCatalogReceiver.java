package ru.artezio.jms.receivers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.jms.converters.ConvertToXML;
import ru.artezio.jms.converters.FactoryMethodForConverters;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component("messageListenerConvertFile")
public class JmsConvertCatalogReceiver implements MessageListener {

    @Autowired
    FactoryMethodForConverters factoryMethodForConverters;

    public void onMessage(Message message) {
        try {
            MultipartFile multipartFile = JmsHelper.convertMessageToMultipartFile(message);
            ConvertToXML convertToXML = factoryMethodForConverters.getConverter(multipartFile.getOriginalFilename());
            convertToXML.convertFile(multipartFile,message.getStringProperty("pathFile"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
