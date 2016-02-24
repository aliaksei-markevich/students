package ru.artezio.dbWithView.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.artezio.dbWithView.db_helpers.HibernateDAO;
import ru.artezio.dbWithView.models.TreeCreater;

@Controller
public class ViewController {

    @Autowired
    @Qualifier("dbHelperClient")
    HibernateDAO dbHelper;

    @Autowired
    TreeCreater treeNode;

    @RequestMapping(value = "/viewList",method = RequestMethod.GET)
    public String showList(Model model) {
        model.addAttribute("data", dbHelper.exportFromDB());
        return "ViewList";
    }

    @RequestMapping(value = "/viewTree",method = RequestMethod.GET)
    public String showTree(Model model) {
        String tree = treeNode.createTree();
        model.addAttribute("tree", tree);
        return "ViewTree";
    }

    @RequestMapping(value = "/viewList",method = RequestMethod.POST)
    public String searchAndShowListClient(@RequestParam(required=false) Integer index, Model model) {
        if(index!=null){
            model.addAttribute("index",index);
            System.out.println(index);
        }
        model.addAttribute("data", dbHelper.exportFromDB());
        return "ViewList";
    }

    @RequestMapping(value = "/viewTree",method = RequestMethod.POST)
    public String searchAndShowTree(@RequestParam(required=false) Integer index, Model model) {
        if(index!=null){
            model.addAttribute("index","\""+index+"\"");
            System.out.println(index);
        }
        String tree = treeNode.createTree();
        model.addAttribute("tree", tree);
        return "ViewTree";
    }

}
