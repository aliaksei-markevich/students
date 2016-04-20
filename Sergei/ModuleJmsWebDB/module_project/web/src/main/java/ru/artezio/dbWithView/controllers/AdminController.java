package ru.artezio.dbWithView.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.db.db_helpers.HibernateDAO;
import ru.artezio.db.dto.ObjectForJSON;
import ru.artezio.dbWithView.jms.senders.CatalogJmsSender;

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
    CatalogJmsSender catalogJmsSender;


    @RequestMapping(method = RequestMethod.GET)
    public String showAndDeleteImport(@RequestParam(value = "clear", required = false) Integer clear) {
        if (clear != null && clear == 1) {
            dbHelperClient.clearTable();
        }
        if (clear != null && clear == 2) {
            dbHelperTree.clearTable();
        }
        return "ImportTables";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ObjectForJSON importTables(@RequestParam("file") MultipartFile file) {
        ObjectForJSON obj = null;
        try {
            if (file != null && file.getName() != null) {
                //Если фал xls то в список, если csv то в дерево
                // obj = factoryMethodForUploaders.getUploader(file).uploadFile(file);
                //Обратно получить количество обновленных строк
                catalogJmsSender.sendMessages(file);
                obj = new ObjectForJSON();
                obj.setStatus("OK");
                obj.setSizeFile(file.getSize());
            }
        } catch (Exception ex) {
            obj = new ObjectForJSON();
            obj.setStatus(ex.getMessage());
            obj.setCountUploadRecords(0);
            obj.setSizeFile(file.getSize());
        } finally {
            if (obj == null) {
                obj = new ObjectForJSON();
                obj.setStatus("Ошибка в файле файла");
                obj.setCountUploadRecords(0);
                obj.setSizeFile(file.getSize());
            }
            return obj;
        }
    }
}

