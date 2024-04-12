package com.javaspringpagination.javaspringpagination;

import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {


    public BookDto convert(Book from){
        return BookDto.builder()
                .id(from.getId())
                .name(from.getName())
                .createdAt(from.getCreatedAt().toString())
                .build();
    }
}
