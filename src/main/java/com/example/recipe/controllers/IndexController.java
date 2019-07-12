package com.example.recipe.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * created by tianyh on 6/10/19 1:54 PM
 */
@Slf4j
@Controller
public class IndexController {

    public IndexController() {
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage() {
        log.debug("index page is in service");
        return "index";
    }
}
