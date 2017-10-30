package com.cefalo.newstestproject.module.news.dto.response.v1;


import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;
import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class NewsResponseV1DTO extends GenereicResponseDTO {

    @XmlElement(name = "news")
    private List<NewsV1DTO> news;

    public NewsResponseV1DTO() {
        super();
    }

    public NewsResponseV1DTO(String statusCode, String message, List<NewsV1DTO> news) {
        super(statusCode, message);
        this.news = news;
    }

    public NewsResponseV1DTO(String statusCode, String message) {
        super(statusCode, message);
    }

    public NewsResponseV1DTO(String statusCode, String message, String exceptionMessage) {
        super(statusCode, message,exceptionMessage);
    }


    public List<NewsV1DTO> getNews() {
        return news;
    }

    public void setNews(List<NewsV1DTO> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return super.toString() + " NewsResponseV1DTO{" +
                "news=" + news +
                '}';
    }
}
