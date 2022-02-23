package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.domain.Timestamped;
import com.sparta.hanghare99_clonecording.dto.CommentRegisterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String content;

    public Comment(String content, Board board, User user){
        this.content = content;
        this.board = board;
        this.user = user;
    }

    public void update(CommentRegisterDto requestDto) {
        this.content = requestDto.getContent();
    }
}
