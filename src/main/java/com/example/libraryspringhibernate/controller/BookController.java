package com.example.libraryspringhibernate.controller;


import com.example.libraryspringhibernate.exeption.ResourceNotFoundException;
import com.example.libraryspringhibernate.model.Book;
import com.example.libraryspringhibernate.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @GetMapping("bookList")
    public List<Book> getAllBooks(){
        logger.info("getAllBooks called...");
        return bookRepository.findAll();
    }

    @GetMapping("bookList/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {
        logger.info("getBookById called...bookId is :"+bookId);
        Book book=bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: "+bookId));
        return ResponseEntity.ok().body(book);
    }

//    public Book createBook(@Valid @RequestBody Book book){

    @PostMapping("newBook")
    public Book createBook(@RequestBody Book book){
        logger.info("createBook called...BookTitle :"+book.getBookTitle() +" Author :" +book.getAuthor());
        return bookRepository.save(book);
    }

     @PutMapping("bookList/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Long bookId,
                                                   @RequestBody Book bookDetails) throws ResourceNotFoundException {
         logger.info("updateBook called...bookId is :"+bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
         logger.info("Book found...BookTitle is :"+book.getBookTitle());
         book.setId(bookDetails.getId());
         book.setBookTitle(bookDetails.getBookTitle());
         book.setAuthor(bookDetails.getAuthor());

//        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @DeleteMapping("bookList/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {
        logger.info("deleteBook called...bookId is :"+bookId);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));
        logger.info("Book found...BookTitle is :"+book.getBookTitle());
        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
