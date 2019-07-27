package com.example.recipe.controllers;

import com.example.recipe.commands.IngredientCommand;
import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.service.IngredientService;
import com.example.recipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * created by tianyh on 7/24/19 11:42 PM
 */
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @RequestMapping(value = "/recipe/{recipeId}/ingredients", method = RequestMethod.GET)
    public String listIngredients(@PathVariable String recipeId, Model model) {

        RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(recipeId));

        model.addAttribute("recipe", recipeCommand);

        return "recipe/ingredient/list";
    }

    @RequestMapping(value = "/recipe/{recipeId}/ingredient/{ingredientId}/show", method = RequestMethod.GET)
    public String showIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model) {

        IngredientCommand ingredientCommand = ingredientService
                .findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId));

        model.addAttribute("ingredient", ingredientCommand);

        return "recipe/ingredient/show";
    }

}
