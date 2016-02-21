package ru.artezio.dbWithView.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.DBHelperDAO;
import ru.artezio.dbWithView.dto.ObjectForJSON;
import ru.artezio.dbWithView.springhelpers.SingletonContext;
import ru.artezio.dbWithView.uploaders.Uploader;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/import")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAndDeleteImport(HttpServletRequest req) {
        DBHelperDAO dbHelper = null;
        AbstractApplicationContext context = SingletonContext.getInstance();
        if (req.getParameter("clear") != null && req.getParameter("clear").equals("1")) {
            dbHelper = (DBHelperDAO) context.getBean("dbheleprclients");
            dbHelper.clearTable();
        }
        if (req.getParameter("clear") != null && req.getParameter("clear").equals("2")) {
            dbHelper = (DBHelperDAO) context.getBean("dbhelpertreetable");
            dbHelper.clearTable();
        }
        return "ImportTables";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjectForJSON importTables(@RequestParam("file") MultipartFile file) {
        int lenghtFileName = 0;
        AbstractApplicationContext context = SingletonContext.getInstance();
        ObjectForJSON obj = null;
        Uploader fileUpload = null;
        String fileNameProp;
        try {
            if (file != null && file.getName() != null) {
                lenghtFileName = file.getOriginalFilename().length();
                fileNameProp = file.getOriginalFilename().substring(lenghtFileName - 3, lenghtFileName);
                //Если фал xls то в список, если csv то в дерево
                if (fileNameProp.equals("xls")) {
                    fileUpload = (Uploader) context.getBean("xsluploder");
                    obj = fileUpload.uploadFile(file);
                } else if (fileNameProp.equals("csv")) {
                    fileUpload = (Uploader) context.getBean("csvuploder");
                    obj = fileUpload.uploadFile(file);
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

