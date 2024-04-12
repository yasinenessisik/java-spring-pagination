package com.javaspringpagination.javaspringpagination;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/pageable")
    public ResponseEntity<Page<BookDto>> getPageable(Pageable pageable){
        return ResponseEntity.ok(bookService.bookDtoPageable(pageable));
    }


    @GetMapping("/slice")
    public ResponseEntity<Slice<BookDto>> getSlice(Pageable pageable){
        return ResponseEntity.ok(bookService.bookDtoSlice(pageable));
    }
    @GetMapping("/all")
    public ResponseEntity<Set<BookDto>> getAll(){
        return ResponseEntity.ok(bookService.getAll());
    }
    @GetMapping("/allQuery")
    public ResponseEntity<Set<BookDto>> getAllQuery(){
        return ResponseEntity.ok(bookService.getAllByJpaQuery());
    }

}
