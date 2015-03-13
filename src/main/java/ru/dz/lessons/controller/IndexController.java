package ru.dz.lessons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by blvp on 13.03.15.
 */
@Controller
@RequestMapping(method = RequestMethod.GET)
public class IndexController {

    @RequestMapping("/")
    public String renderMain(Model model){
        return "index";
    }
}
