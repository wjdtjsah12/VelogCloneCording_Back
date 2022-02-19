package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRegisterResponseDto {

    private Long boardId;

    public BoardRegisterResponseDto(Long boardId){
        this.boardId = boardId;

    }
}
