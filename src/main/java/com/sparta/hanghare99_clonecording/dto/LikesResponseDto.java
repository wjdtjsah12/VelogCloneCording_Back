package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LikesResponseDto {
    private Boolean result;
    private Long likesNum;

    public LikesResponseDto(Boolean result, Long likesNum){
        this.result = result;
        this.likesNum = likesNum;
    }
}
