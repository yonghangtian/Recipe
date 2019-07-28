package com.example.recipe.service;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;
import com.example.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * created by tianyh on 7/28/19 1:48 PM
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    UnitOfMeasureRepository unitOfMeasureRepository;
    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll().spliterator(),false).map(unitOfMeasureToUnitOfMeasureCommand::convert).collect(Collectors.toSet());
    }
}
