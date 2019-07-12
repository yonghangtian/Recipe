package com.example.recipe.controllers;

import com.example.recipe.domain.Recipe;
import com.example.recipe.service.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * created by tianyh on 7/10/19 12:39 PM
 */
public class IndexControllerTest {
    
    IndexController indexController;
    
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);
    }
    
    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    
    @Test
    public void getRecipeList() {

        Set<Recipe> recipeSet = new HashSet<>();

        recipeSet.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setId(2L);
        recipeSet.add(recipe);

        when(recipeService.getRecipe()).thenReturn(recipeSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String targetString = indexController.getRecipeList(model);

        verify(recipeService,times(1)).getRecipe();
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        assertEquals("index",targetString);

        assertEquals(2,argumentCaptor.getValue().size());
    }
}