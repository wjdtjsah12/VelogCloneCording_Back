package com.sparta.hanghare99_clonecording.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class TagNameDto {
    private String tagName;

    public TagNameDto(){

    }

    public TagNameDto(String tagName){
        this.tagName = tagName;

    }
}
