package ru.artezio.jms.uploaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("factoryMethodForUploaders")
public class FactoryMethodForUploaders {

    @Autowired
    @Qualifier("xslUploader")
    Uploader fileUploadXSL;

    @Autowired
    @Qualifier("csvUploader")
    Uploader fileUploadCSV;

    public Uploader getUploader(MultipartFile file) throws Exception {
        Uploader uploader;
        if (getExpansion(file).equals("csv")) {
            uploader = fileUploadCSV;
        } else if (getExpansion(file).equals("xls")) {
            uploader = fileUploadXSL;
        } else {
            throw new Exception("Данное расширение не поддерживается");
        }
        return uploader;
    }

    private String getExpansion(MultipartFile file) {
        int lenghtFileName = file.getOriginalFilename().length();
        return file.getOriginalFilename().substring(lenghtFileName - 3, lenghtFileName);
    }
}
