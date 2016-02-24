package ru.artezio.dbWithView.controllers;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.artezio.dbWithView.db_helpers.HibernateDAO;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.models.TreeBranch;

import java.util.ArrayList;
import java.util.Iterator;
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


    @RequestMapping(value="/client",method = RequestMethod.POST)
    @ResponseBody
    public List<Client> searchRequestClient(@RequestParam String nameStartsWithClient) {
        List<Client> listClients = dbHelperClient.exportFromDBWithString(nameStartsWithClient);
        return listClients;
    }

    @RequestMapping(value="/tree",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeBranch> searchRequestTree(@RequestParam String nameStartsWithTree) {
        List<TreeBranch> listBranches = dbHelperTree.exportFromDBWithString(nameStartsWithTree);
        return listBranches;
    }
}
