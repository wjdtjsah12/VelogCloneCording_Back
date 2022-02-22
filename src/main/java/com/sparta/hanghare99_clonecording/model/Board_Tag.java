package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.dto.TagDto;
import com.sparta.hanghare99_clonecording.repository.Board_TagRepository;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Board_Tag {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "board_tag_Id", nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    public Board_Tag(Board board, Tag tag){
        this.board = board;
        this.tag = tag;

    }
}
