//package com.sparta.hanghare99_clonecording.service;
//
//import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
//import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
//import com.sparta.hanghare99_clonecording.dto.CommentResponseDto;
//import com.sparta.hanghare99_clonecording.model.Board;
//import com.sparta.hanghare99_clonecording.model.Comment;
//import com.sparta.hanghare99_clonecording.model.User;
//import com.sparta.hanghare99_clonecording.repository.BoardRepository;
//import com.sparta.hanghare99_clonecording.repository.CommentRepository;
//import com.sparta.hanghare99_clonecording.security.UserDetailsImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class CommentService {
//    private final BoardRepository boardRepository;
//    private final CommentRepository commentRepository;
//
//    public CommentResponseDto registerComment(Long boardId, CommentRegisterDto requestDto, UserDetailsImpl userDetails) {
////        Board board = boardRepository.findById(boardId).orElseThrow(() -> new UsernameNotFoundException("registerComment 내부 findByBoardId 오류"));
//        Board boardId(BoardRegisterDto requestDto, User user)
//
//        Comment comment = new Comment(requestDto.getContent(), board, userDetails.getUser());
//        commentRepository.save(comment);
//
//        CommentResponseDto commentResponseDto = new CommentResponseDto();
//        commentResponseDto.setComment_Id(comment.getId());
//        return commentResponseDto;
//    }
//}
