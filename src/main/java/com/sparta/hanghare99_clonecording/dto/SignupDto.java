package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SignupDto {
    //이메일
    private String email;
    //아이디
    private String userId;
    //패스워드
    private String password;
    //성명
    private String username;
    //프로필넘버
    private Long profileNum;
    //소개 글
    private String introduce;
}
