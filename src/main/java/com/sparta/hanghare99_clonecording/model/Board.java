package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.domain.Timestamped;
import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column
    private String contentSummary;

    @Column
    private String thumbnailImageUrl;

    @Column
    private Long likeCount;

    @Column
    private Long commentCount;

    @OneToMany
    @Column(name = "board_id")
    private List<Likes> likesList = new ArrayList<>();

    public Board(BoardRegisterDto requestDto, User user){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.contentSummary = requestDto.getContentSummary();
        this.thumbnailImageUrl = requestDto.getThumbnailImageUrl();
        this.user = user;
    }

    public void update(BoardRegisterDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.contentSummary = requestDto.getContentSummary();
        this.thumbnailImageUrl = requestDto.getThumbnailImageUrl();
    }

    public void likeBoards (Long id, Long likeCount, Long commentCount, String title, String thumbnailImageUrl, String contentSummary) {
        this.id = id;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.title = title;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.contentSummary = contentSummary;
    }

}
