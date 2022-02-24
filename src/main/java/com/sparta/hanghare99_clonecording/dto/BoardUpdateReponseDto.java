package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardUpdateReponseDto {
    private String userId;
    private String title;
    private String content;

    public BoardUpdateReponseDto (String userId, String title, String content){
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
