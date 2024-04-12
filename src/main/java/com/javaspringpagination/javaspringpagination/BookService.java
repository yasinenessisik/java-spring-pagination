package com.javaspringpagination.javaspringpagination;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter converter;

    //{
    //  "page": 0,
    //  "size": 100,
    //  "sort": [
    //   "id,asc"
    //  ]
    //}
    public Page<BookDto> bookDtoPageable(Pageable pageable){
        return bookRepository.findAll(pageable).map(book -> converter.convert(book));
    }

    public Slice<BookDto> bookDtoSlice(Pageable pageable){
        return bookRepository.findAll(pageable).map(book -> converter.convert(book));
    }


    public Set<BookDto> getAll() {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream().map(book ->
                converter.convert(book)
                ).collect(Collectors.toSet());
    }
    public Set<BookDto> getAllByJpaQuery() {
        return bookRepository.findAllByOrderByIdDesc().stream().map(book ->
                converter.convert(book)
        ).collect(Collectors.toSet());
    }
}
