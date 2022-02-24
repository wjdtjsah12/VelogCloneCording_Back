package com.sparta.hanghare99_clonecording.model;

import com.sparta.hanghare99_clonecording.domain.Timestamped;
import com.sparta.hanghare99_clonecording.dto.BoardRegisterDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "board_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
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
    private Long likesCount;

    @Column
    private Long registerdUid;

    @OneToMany
    @Column(name = "tag_id")
    private List<Tag> tagList = new ArrayList<>();

    public Board(BoardRegisterDto requestDto, User user){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.contentSummary = requestDto.getContentSummary();
        this.thumbnailImageUrl = requestDto.getThumbnailImageUrl();
        this.registerdUid = user.getId();
        this.user = user;
        this.likesCount = 0L;
    }

    public Board(String title, User user,Long boardId1, List<Tag> tag1) {
        this.title = title;
        this.user = user;
        this.id = boardId1;
        this.tagList = tag1;
    }

    public void setTag(List<Tag> tag1) {
        this.tagList = tag1;
    }

    public void update(BoardRegisterDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.contentSummary = requestDto.getContentSummary();
        this.thumbnailImageUrl = requestDto.getThumbnailImageUrl();
    }

    public void updateLikesCount(Long likes){
        this.likesCount = likes;
    }
}
