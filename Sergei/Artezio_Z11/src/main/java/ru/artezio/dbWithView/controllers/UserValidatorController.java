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

   /* //занести в cookie
    @RequestMapping(value = "/success_login.addCookie", method = RequestMethod.GET)
    public String addCookies(@RequestParam String region, HttpServletRequest request, HttpServletResponse response, Model model) {
        final int expiryTime = 60 ;
        return changeCookies(request, response, model, expiryTime, region);
    }

    @RequestMapping(value = "/success_login.deleteCookie", method = RequestMethod.GET)
    public String deleteCookies(HttpServletRequest request, HttpServletResponse response, Model model) {
        return changeCookies(request, response, model, 0, null);
    }

    private String changeCookies(HttpServletRequest request, HttpServletResponse response, Model model, int expiryTime, String region) {
        showUserName(request,model);
        Cookie cookie = new Cookie("region", region);
        cookie.setMaxAge(expiryTime);
        response.addCookie(cookie);
        return "ChangeCookie";
    }*/

    private void showUserName(HttpServletRequest request, Model model){
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            model.addAttribute("user_name", principal.getName());
        }
    }
}
