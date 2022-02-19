package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
import com.sparta.hanghare99_clonecording.dto.CommentRegisterResponseDto;
import com.sparta.hanghare99_clonecording.dto.CommentResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Comment;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.CommentRepository;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import com.sparta.hanghare99_clonecording.validation.CommentValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentRegisterResponseDto registerComment(Long boardId, CommentRegisterDto requestDto) {
        // boardId, Dto 유효성검사
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("registerComment 내부 findByBoardId 오류"));
        CommentValidation.validationCommentRegister(requestDto);


        // 테스트용 userId 1L로 설정
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("registerComment 내부 findByUserId 오류"));
        Comment comment = new Comment(requestDto.getContent(), board, user);
        commentRepository.save(comment);

        CommentRegisterResponseDto commentResponseDto = new CommentRegisterResponseDto();
        commentResponseDto.setComment_Id(comment.getId());
        return commentResponseDto;
    }
    @Transactional
    public void updateComment(Long commentId, CommentRegisterDto requestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("updateComment 내부 findByCommentId 오류"));

        Optional<Board> board = boardRepository.findById(comment.getBoard().getId());
        if(!board.isPresent()){
            throw new IllegalArgumentException("해당 게시글이 없습니다.");
        }
        // content 유효성검사
        CommentValidation.validationCommentRegister(requestDto);

        comment.update(requestDto);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("deleteComment 내부 findByCommentId 오류"));
        commentRepository.delete(comment);
    }

    public List<CommentResponseDto> getComments(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("getComments 내부 findByBoardId 오류"));
        List <Comment> commentList = commentRepository.findAllByBoard(board);

        // user정보 노출 방지위해서 CommentResponseDto로 response
        List <CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for(Comment comment : commentList){
            CommentResponseDto commentResponseDto = new CommentResponseDto();
            commentResponseDto.setContent(comment.getContent());
            commentResponseDto.setUsername(comment.getUser().getUsername());
            commentResponseDto.setCreatedAt(comment.getCreatedAt());
            commentResponseDtoList.add(commentResponseDto);
        }

        return commentResponseDtoList;
    }
}
