package com.example.libraryspringhibernate.repository;


import com.example.libraryspringhibernate.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {
}
