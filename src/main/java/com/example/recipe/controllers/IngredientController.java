package com.example.recipe.controllers;

import com.example.recipe.commands.IngredientCommand;
import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.service.IngredientService;
import com.example.recipe.service.RecipeService;
import com.example.recipe.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * created by tianyh on 7/24/19 11:42 PM
 */
@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    private final IngredientService ingredientService;

    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
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

    @RequestMapping(value = "/recipe/{recipeId}/ingredient/{ingredientId}/update", method = RequestMethod.GET)
    public String updateIngredient(@PathVariable String recipeId, @PathVariable String ingredientId, Model model) {
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(ingredientId)));

        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());

        return "recipe/ingredient/ingredientForm";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand ingredientCommand) {
        IngredientCommand savedIngredientCommand = ingredientService.saveIngredientCommand(ingredientCommand);
        log.debug("saved recipe id " + savedIngredientCommand.getRecipeId());
        log.debug("saved ingredient id " + savedIngredientCommand.getId());

        return "redirect:/recipe/" + savedIngredientCommand.getRecipeId() + "/ingredient/" +
                savedIngredientCommand.getId() + "/show";
    }
}
