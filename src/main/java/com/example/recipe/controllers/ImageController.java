package com.example.recipe.controllers;

import com.example.recipe.service.ImageService;
import com.example.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.PanelUI;

/**
 * created by tianyh on 7/30/19 3:48 PM
 */
@Slf4j
@Controller
public class ImageController {

    ImageService imageService;

    RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/recipe/{recipeId}/image", method = RequestMethod.GET)
    public String getImageForm(@PathVariable String recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

        return "recipe/imageUploadForm";
    }

    @RequestMapping(value = "/recipe/{recipeId}/image", method = RequestMethod.POST)
    public String handleImagePost(@PathVariable String recipeId, @RequestParam("imagefile") MultipartFile file) {

        imageService.saveImageFile(Long.valueOf(recipeId), file);

        return "redirect:/recipe/" + recipeId + "/show";
    }
}
