package ru.artezio.dbWithView.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.db.dto.ObjectForJSON;
import ru.artezio.jms.files_helpers.FilesHelper;
import ru.artezio.db.models.DataForXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Component("CSVToXMLConverter")
public class CSVToXMLConverter extends AbstractConvert{

    @Autowired
    @Qualifier("csvFilesHelper")
    FilesHelper fileHelper;

    @Override
    protected String chooseModel(String pathFile,MultipartFile file,ObjectForJSON status) throws JAXBException, IOException {
        data.setBranches(fileHelper.createElements(file.getInputStream(), status));
        data.setClients(null);
        return createFile(data, pathFile);
    }

    private String createFile(DataForXML data, String pathFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DataForXML.class);
        return super.nameAndSaveFile(data,jaxbContext,pathFile);
    }
}
