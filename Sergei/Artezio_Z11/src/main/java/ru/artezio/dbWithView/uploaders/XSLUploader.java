package ru.artezio.dbWithView.uploaders;

import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.*;
import ru.artezio.dbWithView.files_helpers.FilesHelperInterface;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.dto.ObjectForJSON;

import javax.servlet.http.Part;
import java.util.Collections;
import java.util.List;

public class XSLUploader extends Uploader<Client> {
    DBHelperDAO dbHelper;
    FilesHelperInterface fileHelper;

    public ObjectForJSON uploadFile(MultipartFile file) {
        ObjectForJSON obj = new ObjectForJSON();
        List<Client> listClients= Collections.emptyList();
        obj.setSizeFile(file.getSize());
        super.createRecordInDB(file,listClients,fileHelper,dbHelper,obj);
        return obj;
    }

    public DBHelperDAO getDbHelper() {
        return dbHelper;
    }

    public void setDbHelper(DBHelperDAO dbHelper) {
        this.dbHelper = dbHelper;
    }

    public FilesHelperInterface getFileHelper() {
        return fileHelper;
    }

    public void setFileHelper(FilesHelperInterface fileHelper) {
        this.fileHelper = fileHelper;
    }
}
