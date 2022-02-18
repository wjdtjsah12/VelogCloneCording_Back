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

    public BoardRegisterResponseDto postingBoard(BoardRegisterDto requestDto) {
        Board board = new Board(requestDto);
        return BoardRegisterResponseDto boardRegisterResponseDto = new BoardRegisterResponseDto();
    }
}
