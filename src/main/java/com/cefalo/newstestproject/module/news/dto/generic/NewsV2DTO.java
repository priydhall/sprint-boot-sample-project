package com.cefalo.newstestproject.module.news.dto.generic;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsV2DTO extends NewsV1DTO {

    @NotNull
    @XmlElement(name = "newsId")
    @NotEmpty
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date newsPublishDate;

    public NewsV2DTO(String newsTitle, String newsBody, String newsAuthor, Date newsPublishDate) {
        super(newsTitle, newsBody, newsAuthor);
        this.newsPublishDate = newsPublishDate;
    }

    public NewsV2DTO(int newsId, String newsTitle, String newsBody, String newsAuthor, Date newsPublishDate) {
        super(newsId, newsTitle, newsBody, newsAuthor);
        this.newsPublishDate = newsPublishDate;
    }

    public NewsV2DTO() {
    }

    public Date getNewsPublishDate() {
        return newsPublishDate;
    }

    public void setNewsPublishDate(Date newsPublishDate) {
        this.newsPublishDate = newsPublishDate;
    }

    @Override
    public String toString() {
        return "NewsV2DTO{" +
                "newsPublishDate=" + newsPublishDate +
                ", newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsBody='" + newsBody + '\'' +
                ", newsAuthor='" + newsAuthor + '\'' +
                '}';
    }
}
