package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
import com.sparta.hanghare99_clonecording.dto.CommentResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Comment;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.CommentRepository;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentResponseDto registerComment(Long boardId, CommentRegisterDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("registerComment 내부 findByBoardId 오류"));
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("registerComment 내부 findByUserId 오류"));
        Comment comment = new Comment(requestDto.getContent(), board, user);
        commentRepository.save(comment);

        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setComment_Id(comment.getId());
        return commentResponseDto;
    }
}
