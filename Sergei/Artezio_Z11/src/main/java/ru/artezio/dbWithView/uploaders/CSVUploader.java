package ru.artezio.dbWithView.uploaders;


import ru.artezio.dbWithView.db_helpers.DBHelper;
import ru.artezio.dbWithView.files_helpers.CSVFilesHelper;
import ru.artezio.dbWithView.files_helpers.FilesHelperInterface;
import ru.artezio.dbWithView.models.ObjectForJSON;
import ru.artezio.dbWithView.models.TreeBranch;

import javax.servlet.http.Part;
import java.util.Collections;
import java.util.List;

public class CSVUploader extends Uploader<TreeBranch> {

    public void uploadFile(Part file, ObjectForJSON obj) {
        List<TreeBranch> listBranches = Collections.emptyList();
        obj.setSizeFile(file.getSize());
        DBHelper hibernate=new DBHelper(TreeBranch.class);
        FilesHelperInterface fileHelper=new CSVFilesHelper();
        super.createRecordInDB(file,listBranches,fileHelper,hibernate,obj);
    }
}

