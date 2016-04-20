package ru.artezio.dbWithView.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
public class UserValidatorController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginShow() {
        return "Login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error, Model model, @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Неверный логин/пароль");
        }
        return "Login";
    }

    @RequestMapping(value = "/success_login", method = RequestMethod.GET)
    public String successLogin(HttpServletRequest request, Model model) {
        showUserName(request,model);
        return "LoginSuccess";
    }

    private void showUserName(HttpServletRequest request, Model model){
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            model.addAttribute("user_name", principal.getName());
        }
    }
}
