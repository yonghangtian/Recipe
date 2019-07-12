package com.example.recipe.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created by tianyh on 7/10/19 12:15 PM
 */
public class CategoryTest {
    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }
    @Test
    public void getId() {
        Long id = 4L;
        category.setId(id);
        //id = 5L;
        assertEquals(id,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}