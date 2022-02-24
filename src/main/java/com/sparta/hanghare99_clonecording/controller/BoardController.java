package com.sparta.hanghare99_clonecording.controller;

import com.sparta.hanghare99_clonecording.dto.*;
import com.sparta.hanghare99_clonecording.security.provider.UserDetailsImpl;
import com.sparta.hanghare99_clonecording.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards/likes")
    public List<BoardResponseDto> GetLikesBoards() {
        return boardService.GetLikesBoards();
    }

    @GetMapping("/boards/recent")
    public List<BoardResponseDto> GetRecentBoards() {
        return boardService.GetRecentBoards();
    }

    @PostMapping("/board/posting")
    public BoardRegisterResponseDto postingBoard(@RequestBody BoardRegisterDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.postingBoard(requestDto, userDetails);
    }

    @GetMapping("/board/detail/{postingId}")
    public BoardDetailResponseDto readBoard(@PathVariable Long postingId) {
        return boardService.readBoard(postingId);
    }

    @PutMapping("/board/update/{postingId}")
    public BoardUpdateReponseDto updateBoard(@PathVariable Long postingId, @RequestBody  BoardRegisterDto boardRegisterDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.updateBoard(postingId, boardRegisterDto, userDetails);
    }

    @DeleteMapping("/board/delete/{postingId}")
    public void deleteBoard(@PathVariable Long postingId) {
        boardService.deleteBoard(postingId);
    }
}
