package com.example.recipe.controllers;

import com.example.recipe.domain.Category;
import com.example.recipe.domain.UnitOfMeasure;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Calendar;
import java.util.Optional;

/**
 * @author tianyh
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
