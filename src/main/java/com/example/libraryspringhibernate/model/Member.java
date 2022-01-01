package com.example.libraryspringhibernate.model;

import javax.persistence.*;

@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long memberId;

    @Column(name = "member_name",nullable = false)
    private String memberName;

    @Column(name = "password",nullable = false)
    private String password;

    @OneToOne(mappedBy = "whoBorrow")
    private Borrow whoBorrow;

    public Member(String memberName, String password) {
        this.memberName = memberName;
        this.password = password;
    }

    public Member() {
    }

    public Member(String memberName, String password, Borrow whoBorrow) {

        this.memberName = memberName;
        this.password = password;
        this.whoBorrow = whoBorrow;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
