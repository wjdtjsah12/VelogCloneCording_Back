package com.sparta.hanghare99_clonecording.service;

import com.sparta.hanghare99_clonecording.dto.TagDto;
import com.sparta.hanghare99_clonecording.dto.TagResponseDto;
import com.sparta.hanghare99_clonecording.model.Board;
import com.sparta.hanghare99_clonecording.model.Board_Tag;
import com.sparta.hanghare99_clonecording.model.Tag;
import com.sparta.hanghare99_clonecording.repository.BoardRepository;
import com.sparta.hanghare99_clonecording.repository.Board_TagRepository;
import com.sparta.hanghare99_clonecording.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService {

    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;
    private final Board_TagRepository board_tagRepository;

    public List<TagResponseDto> registerTag(Long boardId, List<TagDto> tagDto){
        List<TagResponseDto> arr = new ArrayList<>();

        Board board = boardRepository.findById(boardId).orElseThrow(
                ()-> new IllegalArgumentException("boardId 오류"));
        for (int i=0; i<tagDto.size(); i++){
            Tag tag = new Tag(tagDto.get(i));
            Tag temp = tagRepository.save(tag);
            Long Ids = temp.getId();
            TagResponseDto tagResponseDto = new TagResponseDto(Ids);

            arr.add(tagResponseDto);

            Board_Tag board_tag = new Board_Tag(board,tag);
            board_tagRepository.save(board_tag);
        }
        return arr;

//        return tagIds.getId();
    }

}
