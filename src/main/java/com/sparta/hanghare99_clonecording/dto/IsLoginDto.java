package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;

@Getter
public class IsLoginDto {
    private String username;

    public IsLoginDto(String username){
        this.username = username;
    }
}
