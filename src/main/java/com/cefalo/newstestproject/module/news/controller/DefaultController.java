package com.cefalo.newstestproject.module.news.controller;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping("/")
    public String getIndexView() {
        return "index";
    }

    @RequestMapping("/createNews")
    public String getCreateNewsView() {
        return "newscreate";
    }

    @RequestMapping(value = ERROR_PATH)
    public String getErrorView() {
        return "/error/404";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}