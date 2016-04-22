package ru.artezio.dbWithView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/managerFiles")
public class ManagerFilesController {

    @RequestMapping(method = RequestMethod.GET, params = "nameFile")
    @ResponseBody
    public Boolean deleteFile(@RequestParam String nameFile, HttpServletRequest request) {
        String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filePath = phyPath + "files/" + nameFile;
        File fileXML = new File(filePath);
        return fileXML.delete();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showFilesManager(Model model, HttpServletRequest request) {
        String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filesPath = phyPath + "files/";
        List<String> listFilesXML = this.getListNameFiles(filesPath);
        model.addAttribute("listFilesXML", listFilesXML);
        return "ManagerFiles";
    }

    private List getListNameFiles(String filesPath) {
        List<String> listNameFilesXML = new ArrayList<>();
        File folderWithXMlFiles = new File(filesPath);
        File[] listOfXMLFiles = folderWithXMlFiles.listFiles();
        if (listOfXMLFiles != null) {
            for (File file : listOfXMLFiles) {
                if (file.isFile() && file.getName().contains(".xml")) {
                    listNameFilesXML.add(file.getName());
                }
            }
        }
        return listNameFilesXML;
    }


}
