package com.orsys.formation.mappers;

import com.orsys.formation.dto.request.CategoryRequestDTO;
import com.orsys.formation.dto.response.CategoryResponseDTO;
import com.orsys.formation.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper((CategoryMapper.class) );

    CategoryResponseDTO toResponse(Category category);

    Category toEntity(CategoryRequestDTO categoryRequestDTO);
}
