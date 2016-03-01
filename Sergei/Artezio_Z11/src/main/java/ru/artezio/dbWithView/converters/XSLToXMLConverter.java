package ru.artezio.dbWithView.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.dto.ObjectForJSON;
import ru.artezio.dbWithView.files_helpers.FilesHelper;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.models.Clients;
import ru.artezio.dbWithView.models.TreeBranches;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component("XSLToXMLConverter")
public class XSLToXMLConverter extends AbstractConvert {

    @Autowired
    @Qualifier("xslFilesHelper")
    FilesHelper fileHelper;

    @Override
    protected String helpConvertFile(String pathFile,MultipartFile file,ObjectForJSON status) throws JAXBException, IOException {
        Clients clients = new Clients();
        clients.setClients(fileHelper.createElements(file.getInputStream(), status));
        return createFile(clients, pathFile);
    }

    private String createFile(Clients clients, String pathFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        return super.helpCreateFile(clients,jaxbContext,pathFile);
    }
}
