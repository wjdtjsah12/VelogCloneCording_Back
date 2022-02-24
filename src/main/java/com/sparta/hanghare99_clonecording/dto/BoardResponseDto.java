package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardResponseDto {
    private Long boardId;
    private String title;
    private String contentSummary;
    private String createdAt;
    private String thumbnailImageUrl;
    private Long registerdUid;
    private int profileNum;
    private String userId;
    private Long likeCount;
    private Long commentCount;

    public BoardResponseDto(Board board, Long likeCount, Long commentCount){
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.contentSummary = board.getContentSummary();
        this.createdAt = board.getCreatedAt();
        this.thumbnailImageUrl = board.getThumbnailImageUrl();
        this.registerdUid = board.getRegisterdUid();
        this.profileNum = board.getUser().getProfileNum();
        this.userId = board.getUser().getUseride();
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }
}
