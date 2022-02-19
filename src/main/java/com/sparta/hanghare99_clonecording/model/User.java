package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.dto.SignupRequestDto;
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

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private Long profileNum;
    // 랜덤 난수 생성 구현해야합니다.

    public User(SignupRequestDto requestDto){
        this.email = requestDto.getEmail();
        this.userId = requestDto.getUserId();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.introduce = requestDto.getIntroduce();
        this.profileNum = requestDto.getProfileNum();
    }
}
