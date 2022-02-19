//package com.sparta.hanghare99_clonecording.controller;
//
//import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
//import com.sparta.hanghare99_clonecording.dto.CommentResponseDto;
//import com.sparta.hanghare99_clonecording.security.UserDetailsImpl;
//import com.sparta.hanghare99_clonecording.service.CommentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class CommentController {
//    private final CommentService commentService;
//
//    // comment 등록 메소드
//    @GetMapping("/comment/write/{boardId}")
//    public CommentResponseDto registerComment(@PathVariable Long boardId, CommentRegisterDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        return commentService.registerComment(boardId, requestDto, userDetails);
//    }
//}
