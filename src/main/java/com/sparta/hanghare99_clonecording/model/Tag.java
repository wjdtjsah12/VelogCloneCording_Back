package com.sparta.hanghare99_clonecording.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.sparta.hanghare99_clonecording.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@NoArgsConstructor
@Entity @Getter
public class Tag {

    //TagsId
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "tags_id", nullable = false)
    private Long id;

    //태그이름
    @Column
    private String tagName;

    public Tag(TagDto tagdto) {
    this.tagName = tagName;
    }
}