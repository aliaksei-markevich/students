package ru.artezio.webflow.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Администратор on 07.07.2016.
 */
@Controller
public class SimpleController {

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ModelAndView download() {
        return new ModelAndView("main");
    }
}
