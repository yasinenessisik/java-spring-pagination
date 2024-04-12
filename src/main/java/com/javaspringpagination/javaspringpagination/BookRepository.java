package com.javaspringpagination.javaspringpagination;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Set<Book> findAllByOrderByIdDesc();
}
