package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LikesRegisterResponseDto {
    private Long likesId;

    public LikesRegisterResponseDto(Long likesId){
        this.likesId = likesId;
    }
}
