package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.BoardGetLikesResponseDto;
import com.sparta.hanghare99_clonecording.dto.LikesRegisterResponseDto;
import com.sparta.hanghare99_clonecording.dto.LikesResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Likes;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.LikesRepository;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import com.sparta.hanghare99_clonecording.security.provider.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    public LikesRegisterResponseDto registerLikes(Long boardId, UserDetailsImpl userDetails) {
        Optional <Board> board = boardRepository.findById(boardId);
        if(!board.isPresent()){
            throw new IllegalArgumentException("해당 게시글이 없습니다.");
        }

        User user = userRepository.findById(userDetails.getUser().getId()).get();

        Optional <Likes> likesCheck = likesRepository.findByBoardAndUser(board.get(), user);
        if(likesCheck.isPresent()){
            throw new IllegalArgumentException("이미 좋아요 상태입니다.");
        }

        Likes likes = new Likes(board.get(), user);
        likesRepository.save(likes);
        return new LikesRegisterResponseDto(likes.getId());
    }

    public void deleteLikes(Long likesId) {
        Likes likes = likesRepository.findById(likesId).orElseThrow(() -> new IllegalArgumentException("deleteLike 내부 findByLikesId 오류"));
        likesRepository.delete(likes);
    }

    // 좋아요 등록 및 삭제
    public LikesResponseDto registerOrDeleteLike(Long boardId, UserDetailsImpl userDetails) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("registerOrDeleteLike 내부 findByBoardId 오류"));
        User user = userDetails.getUser();
        Optional<Likes> likes = likesRepository.findByBoardAndUser(board, user);
        if (likes.isPresent()) {
            likesRepository.delete(likes.get());
            board.updateLikesCount(board.getLikesCount()-1L);
            boardRepository.save(board);
            return new LikesResponseDto(false, board.getLikesCount());
        }
        Likes newLikes = new Likes(board, user);
        likesRepository.save(newLikes);
        board.updateLikesCount(board.getLikesCount()+1L);
        boardRepository.save(board);
        return new LikesResponseDto(true, board.getLikesCount());
    }

    public BoardGetLikesResponseDto getBoardsLikes(Long boardId, UserDetailsImpl userDetails) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("getBoardsLikes 내부 findByBoardId 오류"));
        User user = userDetails.getUser();
        Optional<Likes> likes = likesRepository.findByBoardAndUser(board, user);
        if (likes.isPresent()) {
            return new BoardGetLikesResponseDto(true);
        }
        return new BoardGetLikesResponseDto(false);
    }
}
