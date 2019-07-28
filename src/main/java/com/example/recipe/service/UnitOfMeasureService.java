package com.example.recipe.service;

import com.example.recipe.commands.UnitOfMeasureCommand;


import java.util.Set;

/**
 * created by tianyh on 7/28/19 1:47 PM
 */

public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();
}
