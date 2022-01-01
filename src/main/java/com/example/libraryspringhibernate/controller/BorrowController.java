package com.example.libraryspringhibernate.controller;


import com.example.libraryspringhibernate.exeption.ResourceNotFoundException;
import com.example.libraryspringhibernate.model.Book;
import com.example.libraryspringhibernate.model.Borrow;
import com.example.libraryspringhibernate.repository.BookRepository;
import com.example.libraryspringhibernate.repository.BorrowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
//import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class BorrowController {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BorrowController.class);


    @GetMapping("borrow/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable(value = "id") Long borrowId)
            throws ResourceNotFoundException {
        logger.info("getBorrowById called...id : "+borrowId);
        Borrow borrow=borrowRepository.findById(borrowId).orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: "+borrowId));
        return ResponseEntity.ok().body(borrow);
    }

    @PostMapping("newBorrow")
    @ResponseBody
    public Borrow createBorrow(@RequestBody Borrow borrow)  {
        logger.info("v called...id : "+borrow.getBorrowId() +"BrrowedBook :"+borrow.getBrrowedBooks().get(1)+"StartDate : "+borrow.getStartDate()+
                        "ReturnedDate : "+borrow.getReturnedDate()+ "WhomBrrowedBook is :"+borrow.getWhoBorrow());
        Borrow bw=borrowRepository.save(borrow);
        for(Book book :borrow.getBrrowedBooks()){
            try {
                Book bk=bookRepository.findById(book.getId()).orElseThrow(() -> new ResourceNotFoundException("book not found for this id :: "+book.getId()));
                bk.setBorrow(bw);
                bookRepository.save(bk);
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        return borrowRepository.save(borrow);
    }

    @DeleteMapping("borrow/{id}")
    public Map<String, Boolean> deleteBorrow(@PathVariable(value = "id") Long borrowId)
            throws ResourceNotFoundException {
        logger.info("deleteBorrow called...id : "+borrowId);
        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrow not found for this id :: " + borrowId));

        borrowRepository.delete(borrow);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
