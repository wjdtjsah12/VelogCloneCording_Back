package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SignupResponseDto {
    private Long registerUserId;
    private String statusHttp;
    private String errorMessage;

    public SignupResponseDto(Long registerUserId, String statusHttp, String errorMessage){
        this.registerUserId = registerUserId;
        this.statusHttp = statusHttp;
        this.errorMessage = errorMessage;
    }
}
