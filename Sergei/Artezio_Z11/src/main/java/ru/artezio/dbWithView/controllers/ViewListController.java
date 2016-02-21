package ru.artezio.dbWithView.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.artezio.dbWithView.db_helpers.DBHelperDAO;
import ru.artezio.dbWithView.springhelpers.SingletonContext;

@Controller
@RequestMapping("/viewList")
public class ViewListController {

    @RequestMapping(method = RequestMethod.GET)
    public String showList(Model model) {
        AbstractApplicationContext context = SingletonContext.getInstance();
        DBHelperDAO dbHelper = (DBHelperDAO) context.getBean("dbheleprclients");
        model.addAttribute("data", dbHelper.exportFromDB());
        return "ViewList";
    }

}
