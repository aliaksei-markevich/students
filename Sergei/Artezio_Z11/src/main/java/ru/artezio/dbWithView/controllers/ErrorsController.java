package ru.artezio.dbWithView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorsController {

    @RequestMapping(value = "/errors/404.html")
    public String handle400() {
        return "ErrorJSP";
    }

    @RequestMapping(value = "/errors/403.html")
    public String handle403() {
        return "ErrorUser";
    }
}
