package com.example.recipe.repositories;

import com.example.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author tianyh
 * created by tianyh on 6/14/19 10:47 AM
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
