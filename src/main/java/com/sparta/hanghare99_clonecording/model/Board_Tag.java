package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.dto.TagDto;
import com.sparta.hanghare99_clonecording.repository.Board_TagRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor @Getter @Setter
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
