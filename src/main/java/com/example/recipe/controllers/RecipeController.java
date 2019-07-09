package com.example.recipe.controllers;

import com.example.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tianyh
 * created by tianyh on 6/14/19 3:18 PM
 */
@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index","/index.html"})
    public String getRecipeList(Model model) {
        model.addAttribute("recipes", recipeService.getRecipe());

        return "recipe/index";
    }
}
