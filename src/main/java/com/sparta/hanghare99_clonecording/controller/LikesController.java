package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.BoardGetLikesResponseDto;
import com.sparta.hanghare99_clonecording.dto.LikesRegisterResponseDto;
import com.sparta.hanghare99_clonecording.dto.LikesResponseDto;
import com.sparta.hanghare99_clonecording.security.provider.UserDetailsImpl;
import com.sparta.hanghare99_clonecording.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikesController {
    private final LikesService likesService;



    @PostMapping("/like/register/{boardId}")
    public LikesRegisterResponseDto registerLikes(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.registerLikes(boardId, userDetails);
    }

    @DeleteMapping("/like/delete/{likesId}")
    public void deleteLikes(@PathVariable Long likesId){
        likesService.deleteLikes(likesId);
    }

    @PostMapping("/board/like/{boardId}")
    public LikesResponseDto registerOrDeleteLike (@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.registerOrDeleteLike(boardId, userDetails);
    }

    @GetMapping("/board/like/{boardId}")
    public BoardGetLikesResponseDto getBoardsLikes(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likesService.getBoardsLikes(boardId, userDetails);
    }
}
