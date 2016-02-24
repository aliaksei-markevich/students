package ru.artezio.dbWithView.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.HibernateDAO;
import ru.artezio.dbWithView.dto.ObjectForJSON;
import ru.artezio.dbWithView.uploaders.Uploader;

@Controller
@RequestMapping("/import")
public class AdminController {

    @Autowired
    @Qualifier("dbHelperClient")
    HibernateDAO dbHelperClient;

    @Autowired
    @Qualifier("dbHelperTreeTable")
    HibernateDAO dbHelperTree;

    @Autowired
    @Qualifier("xslUploader")
    Uploader fileUploadXSL;

    @Autowired
    @Qualifier("csvUploader")
    Uploader fileUploadCSV;

    @RequestMapping(method = RequestMethod.GET)
    public String showAndDeleteImport(@RequestParam(value="clear", required=false) Integer clear) {
        if (clear!=null && clear==1) {
            dbHelperClient.clearTable();
        }
        if (clear!=null &&  clear==2) {
           dbHelperTree.clearTable();
        }
        return "ImportTables";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjectForJSON importTables(@RequestParam("file") MultipartFile file) {
        int lenghtFileName = 0;
        ObjectForJSON obj = null;
        String fileNameProp;
        try {
            if (file != null && file.getName() != null) {
                lenghtFileName = file.getOriginalFilename().length();
                fileNameProp = file.getOriginalFilename().substring(lenghtFileName - 3, lenghtFileName);
                //Если фал xls то в список, если csv то в дерево
                if (fileNameProp.equals("xls")) {
                    obj = fileUploadXSL.uploadFile(file);
                } else if (fileNameProp.equals("csv")) {
                    obj = fileUploadCSV.uploadFile(file);
                } else {
                    obj = new ObjectForJSON();
                    obj.setStatus("Ошибка в расширении файла");
                    obj.setCountUploadRecords(0);
                    obj.setSizeFile(file.getSize());
                }
            }
        } finally {
            if(obj==null){
                obj.setStatus("Ошибка в файле файла");
                obj.setCountUploadRecords(0);
                obj.setSizeFile(file.getSize());
            }
            return obj;
        }
    }
}

