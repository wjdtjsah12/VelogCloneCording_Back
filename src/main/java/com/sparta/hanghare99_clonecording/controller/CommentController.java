package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
import com.sparta.hanghare99_clonecording.dto.CommentResponseDto;
import com.sparta.hanghare99_clonecording.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/comment/update/{boardId}/{commentId}")
    public void updateComment(@PathVariable Long commentId){

    }
}
