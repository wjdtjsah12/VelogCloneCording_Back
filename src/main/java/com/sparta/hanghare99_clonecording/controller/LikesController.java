package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.LikesRegisterResponseDto;
import com.sparta.hanghare99_clonecording.dto.LikesResponseDto;
import com.sparta.hanghare99_clonecording.model.Likes;
import com.sparta.hanghare99_clonecording.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LikesController {
    private final LikesService likesService;

    @PostMapping("/like/register/{boardId}")
    public LikesRegisterResponseDto registerLikes(@PathVariable Long boardId){
        return likesService.registerLikes(boardId);
    }

    @DeleteMapping("/like/delete/{likesId}")
    public void deleteLikes(@PathVariable Long likesId){
        likesService.deleteLikes(likesId);
    }

    @GetMapping("/likes/{boardId}")
    public LikesResponseDto getBoardsLikes(@PathVariable Long boardId){
        return likesService.getBoardsLikes(boardId);
    }
}
