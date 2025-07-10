package com.orsys.formation.mappers;

import com.orsys.formation.dto.request.BookRequestDTO;
import com.orsys.formation.dto.response.BookResponseDTO;
import com.orsys.formation.models.Book;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper((BookMapper.class) );

    BookResponseDTO toResponse(Book book);

    Book toEntity(BookRequestDTO bookRequestDTO);
}
