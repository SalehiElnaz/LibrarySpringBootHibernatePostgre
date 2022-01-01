package com.example.libraryspringhibernate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "author" ,nullable = false)
    private String Author;

    @Column(name = "book_Title" ,nullable = false)
    private String bookTitle;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="borrow_id")
    private Borrow borrow;



    public Book(String author, String bookTitle) {
        Author = author;
        this.bookTitle = bookTitle;
    }

    public Book() {
    }

    public Book(String author, String bookTitle, Borrow borrow) {

        Author = author;
        this.bookTitle = bookTitle;
        this.borrow = borrow;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Author='" + Author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }

}
