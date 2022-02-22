package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IsLoginDto {
    private Long id;
    private String username;
    private String userId;
    private String nickname;
    private String introduce;
    private int profileNum;

    public IsLoginDto(Long id, String username, String userId, String nickname, String introduce, int profileNum){
        this.id = id;
        this.username = username;
        this.userId = userId;
        this.nickname = nickname;
        this.introduce = introduce;
        this.profileNum = profileNum;
    }
}
