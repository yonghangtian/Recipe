package com.example.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tianyh
 * created by tianyh on 6/10/19 1:54 PM
 */
@Controller
public class IndexController {
    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage() {
        return "index";
    }
}
