package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.dto.SignupDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    //이메일 -> 중복 안됨
    @Column(nullable = false, unique = true)
    private String email;

    //아이디 -> 중복 안됨
    @Column(nullable = false, unique = true)
    private String userId;

    //성명
    @Column(nullable = false)
    private String username;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //소개
    @Column(nullable = true)
    private String introduce;

    //프로필넘버
    @Column(nullable = true)
    private Long profileNum;
    // 랜덤 난수 생성 구현해야합니다.

    public User(SignupDto requestDto){
        this.email = requestDto.getEmail();
        this.userId = requestDto.getUserId();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.introduce = requestDto.getIntroduce();
        this.profileNum = requestDto.getProfileNum();
    }
}
