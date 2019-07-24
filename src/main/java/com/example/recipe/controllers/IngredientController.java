package com.example.recipe.controllers;

import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by tianyh on 7/24/19 11:42 PM
 */
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping(value = "/recipe/{recipeid}/ingredients", method = RequestMethod.GET)
    public String listIngredients(@PathVariable String recipeid, Model model) {
        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeid));
        model.addAttribute("recipe", recipeCommand);

        return "recipe/ingredient/list";
    }
}
