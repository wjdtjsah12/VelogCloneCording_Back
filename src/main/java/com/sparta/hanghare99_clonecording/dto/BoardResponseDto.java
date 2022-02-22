package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardResponseDto {
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
        this.title = board.getTitle();
        this.contentSummary = board.getContentSummary();
        this.createdAt = board.getCreatedAt();
        this.thumbnailImageUrl = board.getThumbnailImageUrl();
        this.registerdUid = board.getRegisterdUid();
        this.profileNum = board.getUser().getProfileNum();
        this.userId = board.getUser().getUserId();
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }
}
