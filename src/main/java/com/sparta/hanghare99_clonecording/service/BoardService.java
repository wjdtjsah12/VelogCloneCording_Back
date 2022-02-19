package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
import com.sparta.hanghare99_clonecording.dto.BoardRegisterResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> getLikeBoards() {
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return boardList;
    }

    //게시글 작성
    public BoardRegisterResponseDto postingBoard(BoardRegisterDto requestDto) {

        /*User user = userRepository.findById(Id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다.")
        );*/

        Board board = new Board(/*user,*/ requestDto);

        boardRepository.save(board);
        return new BoardRegisterResponseDto();
    }

    //게시글 상세조회
    public Board readBoard(Long board_id) {
        return boardRepository.findAllById(board_id).orElseThorw(
                () -> new NullPointerException("존재하지 않는 글입니다.")
        );
    }

    //게시글 수정
    public Board updateBoard(Long board_id, BoardRegisterResponseDto responseDto) {
        boardService.update(board_id, responseDto);
        );
    }

    //게시글 삭제
    public void deleteBoard(Long board_id) {
        boardRepository.deleteById(board_id);
    }





}
