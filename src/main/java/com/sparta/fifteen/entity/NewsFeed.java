package com.sparta.fifteen.entity;

import com.sparta.fifteen.dto.NewsFeedRequestDto;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="newsFeed")
public class NewsFeed extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long authorId;
    @Column(nullable = false)
    private String content;
    public NewsFeed(NewsFeedRequestDto newsFeedRequestDto){
        this.authorId = newsFeedRequestDto.getAuthorId();
        this.content = newsFeedRequestDto.getContent();
    }
    public NewsFeed(long authorId, String content) {
        this.authorId = authorId;
        this.content = content;
    }

    public NewsFeed() {
        this.authorId=1;
        this.content = "";
    }
}
