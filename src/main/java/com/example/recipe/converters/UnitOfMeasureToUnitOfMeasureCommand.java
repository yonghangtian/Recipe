package com.example.recipe.converters;

import com.example.recipe.commands.UnitOfMeasureCommand;
import com.example.recipe.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * created by tianyh on 7/22/19 11:11 AM
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {


    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {
            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setDescription(unitOfMeasure.getDescription());
            return uomc;
        }
        return null;
    }
}
