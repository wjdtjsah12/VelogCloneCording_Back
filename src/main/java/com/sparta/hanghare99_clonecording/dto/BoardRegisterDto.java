package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRegisterDto {
    private Long id;
    private String title;
    private String content;
    private String thumbnailImageUrl;
    private String contentSummary;

}
