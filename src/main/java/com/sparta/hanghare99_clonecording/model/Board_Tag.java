package com.sparta.hanghare99_clonecording.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Board_Tag {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "board_tag_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public Board_Tag(Board board, Tag tag){
        this.board = board;
        this.tag = tag;

    }
}
