package com.sparta.hanghare99_clonecording.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likes {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "likes_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Likes(Board board, User user){
        this.board = board;
        this.user = user;
    }
}