package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.LikesRegisterResponseDto;
import com.sparta.hanghare99_clonecording.dto.LikesResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Likes;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.LikesRepository;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;

    public LikesRegisterResponseDto registerLikes(Long boardId) {
        Optional <Board> board = boardRepository.findById(boardId);
        if(!board.isPresent()){
            throw new IllegalArgumentException("해당 게시글이 없습니다.");
        }

        // yserId 1L로 설정(테스트용)
        Optional <User> user = userRepository.findById(1L);
        if(!user.isPresent()){
            throw new IllegalArgumentException("해당 유저가 없습니다.");
        }

        Optional <Likes> likesCheck = likesRepository.findByBoardAndUser(board.get(), user.get());
        if(likesCheck.isPresent()){
            throw new IllegalArgumentException("이미 좋아요 상태입니다.");
        }

        Likes likes = new Likes(board.get(), user.get());
        likesRepository.save(likes);
//        System.out.println(board.get().getLikesList().size());
        return new LikesRegisterResponseDto(likes.getId());
    }

    public void deleteLikes(Long likesId) {
        Likes likes = likesRepository.findById(likesId).orElseThrow(() -> new IllegalArgumentException("deleteLike 내부 findByLikesId 오류"));
        likesRepository.delete(likes);
    }

    public LikesResponseDto getBoardsLikes(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("getBoardsLikes 내부 findByBoardId 오류"));
        List <Likes> likesList = likesRepository.findAllByBoard(board);
        Long listSize = (long) likesList.size();
        return new LikesResponseDto(listSize);
    }
}
