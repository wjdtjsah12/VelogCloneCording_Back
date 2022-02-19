package com.sparta.hanghare99_clonecording.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long Id;

    //성명
    @Column(nullable = false)
    private String username;

    //이메일 -> 중복 안됨
    @Column(nullable = false, unique = true)
    private String email;

    //아이디 -> 중복 안됨
    @Column(nullable = false, unique = true)
    private String userId;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //소개
    @Column(nullable = true)
    private String introduce;

    //프로필넘버
    @Column(nullable = true)
    private int profileNum;

    public User(String username, String email, String userId, String password, String introduce, int profileNum) {
        this.username = username;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.introduce = introduce;
        this.profileNum = profileNum;
    }
}