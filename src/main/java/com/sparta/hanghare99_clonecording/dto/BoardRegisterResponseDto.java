package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRegisterResponseDto {
    private Long board_id;


    public BoardRegisterResponseDto(Long board_id) {
        this.board_id = board_id;
    }
}
