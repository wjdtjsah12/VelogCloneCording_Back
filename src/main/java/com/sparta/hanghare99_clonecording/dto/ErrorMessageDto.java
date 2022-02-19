package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

//에러메세지 전달
public class ErrorMessageDto {

    private String statusHttp;
    private String errorMessage;

    public ErrorMessageDto(String statusHttp, String errorMessage){
        this.statusHttp = statusHttp;
        this.errorMessage = errorMessage;
    }
}
