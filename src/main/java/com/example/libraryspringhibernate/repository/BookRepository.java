package com.example.libraryspringhibernate.repository;

import com.example.libraryspringhibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends  JpaRepository<Book,Long> {
}
