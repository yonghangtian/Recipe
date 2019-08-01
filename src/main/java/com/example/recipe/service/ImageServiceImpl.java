package com.example.recipe.service;

import com.example.recipe.domain.Recipe;
import com.example.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * created by tianyh on 7/30/19 3:49 PM
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try{
            Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
            if (recipeOptional.isPresent()) {
                Recipe recipe = recipeOptional.get();

                Byte[] byteObject = new Byte[file.getBytes().length];

                int i = 0;

                for (byte b : file.getBytes()) {
                    byteObject[i++] = b;
                }
                recipe.setImage(byteObject);

                recipeRepository.save(recipe);
            } else {
                log.error("No Recipe found for id: " + recipeId );
            }
        } catch (IOException e) {
            log.error("MultipartFile error occurred.");
            e.printStackTrace();
        }
    }
}
