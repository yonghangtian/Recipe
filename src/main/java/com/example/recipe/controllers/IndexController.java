package com.example.recipe.controllers;

import com.example.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * created by tianyh on 6/10/19 1:54 PM
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"","/","/index", "/index.html"}, method = RequestMethod.GET)
    public String getRecipeList(Model model) {
        log.debug("recipe service is in service");

        model.addAttribute("recipes", recipeService.getRecipe());

        return "index";
    }
}
