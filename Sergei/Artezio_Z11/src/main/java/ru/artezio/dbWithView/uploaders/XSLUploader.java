package ru.artezio.dbWithView.uploaders;

import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.*;
import ru.artezio.dbWithView.files_helpers.FilesHelper;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.dto.ObjectForJSON;

import java.util.Collections;
import java.util.List;

public class XSLUploader extends Uploader<Client> {
    HibernateDAO dbHelper;
    FilesHelper fileHelper;

    public ObjectForJSON uploadFile(MultipartFile file) {
        ObjectForJSON obj = new ObjectForJSON();
        List<Client> listClients= Collections.emptyList();
        obj.setSizeFile(file.getSize());
        super.createRecordInDB(file,listClients,fileHelper,dbHelper,obj);
        return obj;
    }

    public HibernateDAO getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(HibernateDAO dbHelper) {
        this.dbHelper = dbHelper;
    }

    public FilesHelper getFileHelper() {
        return fileHelper;
    }

    public void setFileHelper(FilesHelper fileHelper) {
        this.fileHelper = fileHelper;
    }
}
