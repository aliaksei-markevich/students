package ru.artezio.dbWithView.uploaders;

import ru.artezio.dbWithView.db_helpers.*;
import ru.artezio.dbWithView.files_helpers.FilesHelperInterface;
import ru.artezio.dbWithView.files_helpers.XSLFilesHelper;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.models.ObjectForJSON;

import javax.servlet.http.Part;
import java.util.Collections;
import java.util.List;

public class XSLUploader extends Uploader<Client> {

    public void uploadFile(Part file, ObjectForJSON obj) {
        List<Client> listClients= Collections.emptyList();
        obj.setSizeFile(file.getSize());
        DBHelper hibernate=new TreeHibernateDBHelper();
        FilesHelperInterface fileHelper=new XSLFilesHelper();
        super.createRecordInDB(file,listClients,fileHelper,hibernate,obj);
    }

}
