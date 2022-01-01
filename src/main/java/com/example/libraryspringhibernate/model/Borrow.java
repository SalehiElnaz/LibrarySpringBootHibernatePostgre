package com.example.libraryspringhibernate.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private long borrowId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "returned_date")
    private Date returnedDate;

    @OneToMany(mappedBy = "borrow")
    private List<Book> brrowedBooks;

    @OneToOne
    @JoinColumn(name = "member_Id" ,nullable = false)
    private Member whoBorrow;

    public Borrow(Date startDate, Date returnedDate) {
        this.startDate = startDate;
        this.returnedDate = returnedDate;
    }

//    @JsonCreator
//    public Member Member(@JsonProperty("whoBorrow") Integer memberId ) {
//        this.whoBorrow = new Member();
//        this.whoBorrow.setMemberId(memberId);
//        return whoBorrow;
//    }

    public Borrow() {
    }

    public Borrow(Date startDate, Date returnedDate, List<Book> brrowedBooks, Member whoBorrow) {

        this.startDate = startDate;
        this.returnedDate = returnedDate;
        this.brrowedBooks = brrowedBooks;
        this.whoBorrow = whoBorrow;
    }

    public long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(long borrowId) {
        this.borrowId = borrowId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public List<Book> getBrrowedBooks() {
        return brrowedBooks;
    }

    public void setBrrowedBooks(List<Book> brrowedBooks) {
        this.brrowedBooks = brrowedBooks;
    }

    public Member getWhoBorrow() {
        return whoBorrow;
    }

    public void setWhoBorrow(Member whoBorrow) {
        this.whoBorrow = whoBorrow;
    }

}
