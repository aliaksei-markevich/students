package ru.artezio.dbWithView.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.artezio.db.db_helpers.HibernateDAO;
import ru.artezio.db.models.User;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    @Qualifier("dbHelperUserSite")
    HibernateDAO dbHelperUserSite;

    @RequestMapping(value="/login",params = "new",method = RequestMethod.GET)
    public String createUser(Model model){
        model.addAttribute(new User());
        return "EditFormCreateUser";
    }

    @RequestMapping(value="/login/registration",method = RequestMethod.POST)
    public String addUserFromForm(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "EditFormCreateUser";
        }
        dbHelperUserSite.saveModel(user);
        return "SuccessRegistration";
    }
}
