package com.cefalo.newstestproject.module.news.dto.generic;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsV1DTO {

    @NotNull
    @XmlElement(name = "newsId")
    @NotEmpty
    protected int newsId;

    @NotNull
    @XmlElement(name = "newsTitle")
    @NotEmpty
    protected String newsTitle;

    @NotNull
    @XmlElement(name = "newsBody")
    @NotEmpty
    protected String newsBody;

    @NotNull
    @XmlElement(name = "newsAuthor")
    @NotEmpty
    protected String newsAuthor;


    public NewsV1DTO() {
    }

    public NewsV1DTO(String newsTitle, String newsBody, String newsAuthor) {
        this.newsTitle = newsTitle;
        this.newsBody = newsBody;
        this.newsAuthor = newsAuthor;
    }

    public NewsV1DTO(int newsId, String newsTitle, String newsBody, String newsAuthor) {
        this.newsId = newsId;
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

    @Override
    public String toString() {
        return "NewsV1DTO{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsBody='" + newsBody + '\'' +
                ", newsAuthor='" + newsAuthor + '\'' +
                '}';
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
}
