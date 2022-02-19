package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardUpdateReponseDto {
    private String username;
    private String title;
    private String content;

    public BoardUpdateReponseDto (String username, String title, String content){
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
