package com.example.recipe.service;

import com.example.recipe.commands.RecipeCommand;
import com.example.recipe.domain.Recipe;

import java.util.Set;

/**
 * @author tianyh
 * created by tianyh on 6/14/19 3:17 PM
 */
public interface RecipeService {
    Set<Recipe> getRecipe();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(Long l);
}
