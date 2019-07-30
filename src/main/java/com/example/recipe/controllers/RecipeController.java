package com.example.recipe.controllers;

import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * created by tianyh on 6/14/19 3:18 PM
 */
@Slf4j
@Controller
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping(value = "/recipe/{id}/show", method = RequestMethod.GET)
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/show";
    }

    @RequestMapping(value = "/recipe/new", method = RequestMethod.GET)
    public String newRecipe(Model model) {
        model.addAttribute("recipe",new RecipeCommand());

        return "recipe/recipeForm";
    }

    @RequestMapping(value = "/recipe/{id}/update", method = RequestMethod.GET)
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeForm";
    }

    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute RecipeCommand recipeCommand) {
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(recipeCommand);

        return "redirect:/recipe/" + savedCommand.getId()+"/show";
    }


    @RequestMapping(value = "/recipe/{id}/delete", method = RequestMethod.GET)
    public String deleteById(@PathVariable String id, Model model) {

        log.debug("Deleting id: " + id);
        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/";

    }
}
