package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardGetLikesResponseDto {
    private Boolean result;

    public BoardGetLikesResponseDto(Boolean result){
        this.result = result;
    }
}
