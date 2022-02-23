package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardDetailResponseDto {
    private String userId;
    private String title;
    private String content;
    private String nickname;
    private String thumbnailImageUrl;
    private String createdAt;
    private Long likeCount;
    private Long commentCount;

    public BoardDetailResponseDto(Board board, Long commentCount){
        this.userId = board.getUser().getUseride();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getUser().getNickname();
        this.thumbnailImageUrl = board.getThumbnailImageUrl();
        this.createdAt = board.getCreatedAt();
        this.likeCount = board.getLikesCount();
        this.commentCount = commentCount;
    }
}
