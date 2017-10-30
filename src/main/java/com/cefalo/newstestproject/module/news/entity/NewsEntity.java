package com.cefalo.newstestproject.module.news.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "News")
public class NewsEntity {

    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int newsId;

    @NotNull(message = "News title can not be null")
    @Column(name = "news_title")
    @NotEmpty(message = "News title can not be empty")
    protected String newsTitle;

    @NotNull(message = "News body can not be null")
    @Column(name = "news_body")
    @NotEmpty(message = "News body can not be empty")
    protected String newsBody;

    @NotNull(message = "News author can not be null")
    @Column(name = "news_author")
    @NotEmpty(message = "News author can not be empty")
    protected String newsAuthor;

    public NewsEntity() {
    }


    public NewsEntity(String newsTitle, String newsBody, String newsAuthor) {
        this.newsTitle = newsTitle;
        this.newsBody = newsBody;
        this.newsAuthor = newsAuthor;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsBody='" + newsBody + '\'' +
                ", newsAuthor='" + newsAuthor + '\'' +
                '}';
    }
}
