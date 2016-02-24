package ru.artezio.dbWithView.uploaders;


import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.HibernateDAO;
import ru.artezio.dbWithView.files_helpers.FilesHelper;
import ru.artezio.dbWithView.dto.ObjectForJSON;
import ru.artezio.dbWithView.models.TreeBranch;

import java.util.Collections;
import java.util.List;


public class CSVUploader extends Uploader<TreeBranch> {

    HibernateDAO dbHelper;

    FilesHelper fileHelper;

    public ObjectForJSON uploadFile(MultipartFile file) {
        ObjectForJSON obj = new ObjectForJSON();
        List<TreeBranch> listBranches = Collections.emptyList();
        obj.setSizeFile(file.getSize());
        super.createRecordInDB(file, listBranches, fileHelper, dbHelper, obj);
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

