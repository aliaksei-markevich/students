package ru.artezio.dbWithView.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.jms.senders.CatalogJmsSender;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/convert")
public class ConvertController {

    @Autowired
    CatalogJmsSender catalogJmsSender;

    @RequestMapping(method = RequestMethod.GET)
    public String showConvertPage() {
        return "ConvertFiles";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String convertFile(@RequestParam MultipartFile file, HttpServletRequest request) {
        String phyPath = request.getSession().getServletContext().getRealPath("/");
        String filepath = phyPath + "files/";
        catalogJmsSender.sendMessages(file, filepath);
       /* if (fileNameProp.equals("xls")) {
            downloadFile = xslConverter.convertFile(file, filepath);
        } else{
            downloadFile = csvConverter.convertFile(file, filepath);
        }*/
        //return "./files/" + downloadFile;
        return "./files/";
    }
}
