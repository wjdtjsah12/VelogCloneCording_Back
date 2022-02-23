package com.sparta.hanghare99_clonecording.dto;

import com.sparta.hanghare99_clonecording.model.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor

public class TagResponseDto {
//    private List<Long> tagIds;
        public Long tagIds;

    public TagResponseDto(Long tagIds){
        this.tagIds = tagIds;

    }
}
