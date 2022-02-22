package com.sparta.hanghare99_clonecording.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeBoardsDto {
    private Long id;
    private Long likeCount;
    private Long commentCount;
    private String title;
    private String thumbnailImageUrl;
    private String contentSummary;


}
