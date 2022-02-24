package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.dto.SignupDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "user_id")
    private Long id;

    //이메일 -> 중복 안됨 -> 유저 네임으로 바꿔야함
    @Column(nullable = false, unique = true)
    private String username;

    //아이디 -> 중복 안됨
    @Column(nullable = false, unique = true)
    private String useride;

    //성명 -> 닉네임 change
    @Column(nullable = false)
    private String nickname;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //소개
    @Column
    private String introduce;

    //프로필넘버
    @Column
    private int profileNum;
    // 랜덤 난수 생성 구현해야합니다.

    public User(SignupDto requestDto){
        this.username = requestDto.getUsername();
        this.useride = requestDto.getUserId();
        this.nickname = requestDto.getNickname();
        this.password = requestDto.getPassword();
        this.introduce = requestDto.getIntroduce();
        this.profileNum = new Random().nextInt(4)+1;
    }

}
