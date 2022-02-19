package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
import com.sparta.hanghare99_clonecording.dto.CommentResponseDto;
import com.sparta.hanghare99_clonecording.model.Comment;
import com.sparta.hanghare99_clonecording.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    // comment 등록 메소드
    @PostMapping("/comment/write/{boardId}")
    public CommentResponseDto registerComment(@PathVariable Long boardId, @RequestBody CommentRegisterDto requestDto){
        return commentService.registerComment(boardId, requestDto);
    }

    // comment 수정 메소드
    @PutMapping("/comment/update/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody CommentRegisterDto requestDto){
        commentService.updateComment(commentId, requestDto);
    }

    // comment 삭제 메소드
    @DeleteMapping("/comment/delete/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

    // 해당 Board의 comment 전체 불러오기 메소드
    @GetMapping("/comments/{boardId}")
    public List<Comment> getComments(@PathVariable Long boardId) {
        return commentService.getComments(boardId);
    }
}
