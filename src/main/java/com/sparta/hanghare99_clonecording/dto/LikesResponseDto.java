package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LikesResponseDto {
    private Long boardTotalLikes;

    public LikesResponseDto(Long boardTotalLikes){
        this.boardTotalLikes = boardTotalLikes;
    }
}
