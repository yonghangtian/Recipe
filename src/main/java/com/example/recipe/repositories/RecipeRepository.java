package com.example.recipe.repositories;

import com.example.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author tianyh
 * created by tianyh on 6/14/19 10:46 AM
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
