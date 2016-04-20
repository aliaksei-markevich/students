package ru.artezio.jms.uploaders;

import org.springframework.web.multipart.MultipartFile;
import ru.artezio.db.db_helpers.HibernateDAO;
import ru.artezio.db.dto.ObjectForJSON;
import ru.artezio.db.models.Client;
import ru.artezio.jms.files_helpers.FilesHelper;

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
