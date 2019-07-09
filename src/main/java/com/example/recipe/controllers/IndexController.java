package com.example.recipe.controllers;

import com.example.recipe.domain.Category;
import com.example.recipe.domain.UnitOfMeasure;
import com.example.recipe.repositories.CategoryRepository;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Calendar;
import java.util.Optional;

/**
 * @author tianyh
 * created by tianyh on 6/10/19 1:54 PM
 */
@Controller
public class IndexController {

    public IndexController() {
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getIndexPage() {

        return "index";
    }
}
