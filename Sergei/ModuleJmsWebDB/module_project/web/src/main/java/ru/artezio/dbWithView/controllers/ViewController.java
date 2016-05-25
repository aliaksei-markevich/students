package ru.artezio.dbWithView.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.artezio.db.db_helpers.HibernateDAO;
import ru.artezio.db.models.TreeCreater;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class ViewController {

    static private final Logger log = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    @Qualifier("dbHelperClient")
    HibernateDAO dbHelper;

    @Autowired
    TreeCreater treeNode;

    @RequestMapping(value = "/viewList", method = RequestMethod.GET)
    public String showList(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        MDC.put("userName", principal.getName());
        log.info("просматривает лист filter");
        log.info("просматривает лист(фильтра нет)");
        model.addAttribute("data", dbHelper.exportFromDB());
        return "ViewList";
    }

    @RequestMapping(value = "/viewTree", method = RequestMethod.GET)
    public String showTree(Model model) {
        String tree = treeNode.createTree();
        model.addAttribute("tree", tree);
        return "ViewTree";
    }

    @RequestMapping(value = "/viewList", method = RequestMethod.GET, params = "index")
    public String searchAndShowListClient(@RequestParam(required = false) final Integer index, Model model) {
        if (index != null) {
            model.addAttribute("index", index);
        }
        model.addAttribute("data", dbHelper.exportFromDB());
        return "ViewList";
    }

    @RequestMapping(value = "/viewTree", method = RequestMethod.GET, params = "index")
    public String searchAndShowTree(@RequestParam(required = false) final Integer index, Model model) {
        if (index != null) {
            model.addAttribute("index", "\"" + index + "\"");
        }
        String tree = treeNode.createTree();
        model.addAttribute("tree", tree);
        return "ViewTree";
    }

}
