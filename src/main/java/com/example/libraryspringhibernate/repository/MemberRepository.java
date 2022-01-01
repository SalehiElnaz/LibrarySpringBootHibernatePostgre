package com.example.libraryspringhibernate.repository;

import com.example.libraryspringhibernate.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository  extends JpaRepository<Member,Long> {
}
