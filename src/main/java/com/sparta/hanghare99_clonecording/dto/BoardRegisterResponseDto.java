package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRegisterResponseDto {
<<<<<<< HEAD
    private Long board_id;


    public BoardRegisterResponseDto(Long board_id) {
        this.board_id = board_id;
=======
    private Long boardId;

    public BoardRegisterResponseDto(Long boardId){
        this.boardId = boardId;
>>>>>>> ca598ee6502bc698c525c9faaaaf7cca4159b0b9
    }
}
