package com.example.recipe.service;

import com.example.recipe.commands.IngredientCommand;

/**
 * created by tianyh on 7/27/19 12:18 PM
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

   void deleteByRecipeIdAndIngredientId(Long valueOf, Long valueOf1);
}
