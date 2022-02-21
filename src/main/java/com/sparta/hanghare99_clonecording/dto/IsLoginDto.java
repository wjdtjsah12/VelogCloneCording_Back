package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IsLoginDto {
    private String username;
    private String userId;
    private String nickname;
    private String introduce;
    private int profileNum;

    public IsLoginDto(String username, String userId, String nickname, String introduce, int profileNum){
        this.username = username;
        this.userId = userId;
        this.nickname = nickname;
        this.introduce = introduce;
        this.profileNum = profileNum;
    }
}
