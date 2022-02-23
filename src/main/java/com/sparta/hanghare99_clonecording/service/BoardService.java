package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.*;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Comment;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.CommentRepository;
import com.sparta.hanghare99_clonecording.repository.LikesRepository;
import com.sparta.hanghare99_clonecording.security.provider.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final LikesRepository likesRepository;
    private final CommentRepository commentRepository;

    public List<BoardResponseDto> getLikeBoards() {
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List <BoardResponseDto> boardResponseDtoList = new ArrayList<>();

        for(Board board : boardList){
            Long likeCount = (long)likesRepository.findAllByBoard(board).size();
            Long commentCount = (long)commentRepository.findAllByBoard(board).size();
            boardResponseDtoList.add(new BoardResponseDto(board, likeCount, commentCount));
        }

        return boardResponseDtoList;
    }

    //게시글 작성
    public BoardRegisterResponseDto postingBoard(BoardRegisterDto requestDto, UserDetailsImpl userDetails) {
        Board board = new Board(requestDto, userDetails.getUser());
        //유효성검사
        String title = board.getTitle();

        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }
        boardRepository.save(board);
        return new BoardRegisterResponseDto(board.getId());
    }

    //게시글 상세조회
    public BoardDetailResponseDto readBoard(Long boardId) {
        Board board =  boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 글입니다.")
        );
        List <Comment> commentList = commentRepository.findAllByBoard(board);
        return new BoardDetailResponseDto(board, (long)commentList.size());
    }

    //게시글 수정
    @Transactional
    public BoardUpdateReponseDto updateBoard(Long boardId, BoardRegisterDto requestDto, UserDetailsImpl userDetails) {
       Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 글입니다")
        );

        User user = userDetails.getUser();
        String userId = board.getUser().getUseride();
        String title = requestDto.getTitle();
        String content = requestDto.getContent();

        if (!Objects.equals(board.getRegisterdUid(), user.getId())) {
            throw new IllegalArgumentException("게시글을 수정할 권한이 없습니다");
        } else if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }
        board.update(requestDto);
        return new BoardUpdateReponseDto(userId, title, content);
    }

    //게시글 삭제
    public void deleteBoard(Long boardId) {
        Board board =  boardRepository.findById(boardId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 글입니다.")
        );
        List <Comment> commentList = commentRepository.findAllByBoard(board);
        commentRepository.deleteAll(commentList);
        boardRepository.deleteById(boardId);
    }



//    public BoardLikesDto getBoardsLikes(Long boardId) {
//
//    }
}
