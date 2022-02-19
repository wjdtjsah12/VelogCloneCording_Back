package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRegisterResponseDto {
    private Long id;
    private String title;
    private String content;
    private String thumbnailImageUrl;
    private String contentSummary;

    public BoardRegisterResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.thumbnailImageUrl = board.getThumbnailImageUrl();
        this.contentSummary = board.getContentSummary();
    }
}
