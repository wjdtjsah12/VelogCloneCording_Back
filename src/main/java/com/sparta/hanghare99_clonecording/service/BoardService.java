package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
import com.sparta.hanghare99_clonecording.dto.BoardRegisterResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.User;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<Board> getLikeBoards() {
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return boardList;
    }

    //게시글 작성
    public BoardRegisterResponseDto postingBoard(BoardRegisterDto requestDto) {
<<<<<<< HEAD

        User user = userRepository.findById(Id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다.")
        );

        Board board = new Board(user, requestDto);

=======
        /*User user = userRepository.findById(Id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다.")
        );*/
        //        User user = userDetails.getUser();
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("postingBoard 내부 findByUserId 오류"));
        Board board = new Board(requestDto, user);
>>>>>>> ca598ee6502bc698c525c9faaaaf7cca4159b0b9
        boardRepository.save(board);
        return new BoardRegisterResponseDto(board.getId());
    }

<<<<<<< HEAD
    //게시글 상세조회
    public Board readBoard(Long id) {
        return boardRepository.findAllById(id).orElseThorw(
                () -> new NullPointerException("존재하지 않는 글입니다.")
        );
    }

    //게시글 수정
    public Board updateBoard( BoardRegisterDto boardRegisterDto, Long board_id) {
        Board board = boardRepository.findById(id).orElseThrow(

        );
    }
=======
//    //게시글 상세조회
//    public Board readBoard(Long board_id) {
//        return boardRepository.findAllById(board_id).orElseThorw(
//                () -> new NullPointerException("존재하지 않는 글입니다.")
//        );
//    }
//
//    //게시글 수정
//    public Board updateBoard(Long board_id, BoardRegisterResponseDto responseDto) {
//        boardService.update(board_id, responseDto);
//        );
//    }
>>>>>>> ca598ee6502bc698c525c9faaaaf7cca4159b0b9

    //게시글 삭제
    public void deleteBoard(Long board_id) {
        boardRepository.deleteById(board_id);
    }





}
