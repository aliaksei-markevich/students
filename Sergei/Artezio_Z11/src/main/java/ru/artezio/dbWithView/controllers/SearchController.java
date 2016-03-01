package ru.artezio.dbWithView.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.artezio.dbWithView.db_helpers.HibernateDAO;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.models.TreeBranch;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    @Qualifier("dbHelperClient")
    HibernateDAO dbHelperClient;

    @Autowired
    @Qualifier("dbHelperTreeTable")
    HibernateDAO dbHelperTree;

    @RequestMapping(method = RequestMethod.GET)
    public String showSearchUserView() {
        return "SearchUser";
    }


    @RequestMapping(method = RequestMethod.POST, params = "client")
    @ResponseBody
    public List<Client> searchRequestClient(@RequestParam String textStartsWith) {
        List<Client> listClients = dbHelperClient.exportFromDBWithString(textStartsWith);
        return listClients;
    }

    @RequestMapping(method = RequestMethod.POST, params = "tree")
    @ResponseBody
    public List<TreeBranch> searchRequestTree(@RequestParam String textStartsWith) {
        List<TreeBranch> listBranches = dbHelperTree.exportFromDBWithString(textStartsWith);
        return listBranches;
    }
}
