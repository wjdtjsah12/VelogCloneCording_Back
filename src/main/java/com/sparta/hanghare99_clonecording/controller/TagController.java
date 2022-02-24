package com.sparta.hanghare99_clonecording.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.hanghare99_clonecording.dto.TagDto;
import com.sparta.hanghare99_clonecording.dto.TagNameDto;
import com.sparta.hanghare99_clonecording.dto.TagResponseDto;
import com.sparta.hanghare99_clonecording.model.Tag;
import com.sparta.hanghare99_clonecording.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TagController {

    private final TagService tagService;

    //태그 등록
    @PostMapping("/tag/register/{boardId}")
    public void registerTag(@PathVariable Long boardId, @RequestBody List<TagDto> tagDto) throws Exception {
        tagService.registerTag(boardId,tagDto);
    }

//    //태그 삭제
//    @DeleteMapping("/tag/delete/{tagsId}")
//    public void deleteTag(@PathVariable Long tagsId){
//        tagService.deleteTag(tagsId);
//    }


    //해당 게시글 모든 태그 조회
    @GetMapping("/tags/{boardId}")
    public List<TagNameDto> getTag(@PathVariable Long boardId){
    return tagService.getTag(boardId);
    }

}
