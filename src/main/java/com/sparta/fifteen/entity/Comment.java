package com.sparta.fifteen.entity;

import com.sparta.fifteen.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @Column(columnDefinition = "bigint default 0")
    private Long likes;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "news_feed_id", nullable = false)
    private NewsFeed newsfeed;

    public Comment(String comment, User user, NewsFeed newsfeed) {
        this.comment = comment;
        this.user = user;
        this.newsfeed = newsfeed;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.comment = commentRequestDto.getComment();
    }
}
