package ru.artezio.dbWithView.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.dto.ObjectForJSON;
import ru.artezio.dbWithView.files_helpers.FilesHelper;
import ru.artezio.dbWithView.models.TreeBranches;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.io.IOException;


@Component("CSVToXMLConverter")
public class CSVToXMLConverter extends AbstractConvert{

    @Autowired
    @Qualifier("csvFilesHelper")
    FilesHelper fileHelper;

    @Override
    protected String helpConvertFile(String pathFile,MultipartFile file,ObjectForJSON status) throws JAXBException, IOException {
        TreeBranches branches = new TreeBranches();
        branches.setBranches(fileHelper.createElements(file.getInputStream(), status));
        return createFile(branches, pathFile);
    }

    private String createFile(TreeBranches branches, String pathFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TreeBranches.class);
        return super.helpCreateFile(branches,jaxbContext,pathFile);
    }
}
