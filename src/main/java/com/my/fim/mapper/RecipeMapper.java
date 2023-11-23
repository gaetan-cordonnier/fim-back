package com.my.fim.mapper;

import com.my.fim.dto.RecipeDto;
import com.my.fim.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {

    RecipeMapper MAPPER = Mappers.getMapper(RecipeMapper.class);

    Recipe updateRecipeFromDto(RecipeDto recipeDto, @MappingTarget Recipe recipe);
    RecipeDto mapToDTO(Recipe recipe);
    Recipe mapToModel(RecipeDto recipeDTO);
}
