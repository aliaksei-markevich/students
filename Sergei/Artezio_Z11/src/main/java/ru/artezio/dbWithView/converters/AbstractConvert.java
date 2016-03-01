package ru.artezio.dbWithView.converters;

import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.dto.ObjectForJSON;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class AbstractConvert implements ConvertToXML {

    @Override
    public String convertFile(MultipartFile file, String pathFile) {
        ObjectForJSON status = new ObjectForJSON();
        String fileName = "";
        File fileDIir = new File(pathFile);
        try {
            if (!fileDIir.exists()) {
                fileDIir.mkdir();
            }
            fileName = helpConvertFile(pathFile, file, status);
        } catch (JAXBException e) {
            e.printStackTrace();
            status.setStatus("Ошибка JAXBException");
        } catch (IOException e) {
            e.printStackTrace();
            status.setStatus("Ошибка в потоке");
        }
        return fileName;
    }

    abstract protected String helpConvertFile(String pathFile, MultipartFile file, ObjectForJSON status) throws JAXBException, IOException;


    protected String helpCreateFile(Object items, JAXBContext jaxbContext, String pathFile) throws JAXBException {
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date()) + ".xml";
        pathFile = pathFile + fileName;
        jaxbMarshaller.marshal(items, new File(pathFile));
        return fileName;
    }
}
