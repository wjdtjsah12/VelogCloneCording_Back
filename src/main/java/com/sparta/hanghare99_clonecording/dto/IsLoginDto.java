package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IsLoginDto {
    private String username;

    public IsLoginDto(String username){
        this.username = username;
    }
}
