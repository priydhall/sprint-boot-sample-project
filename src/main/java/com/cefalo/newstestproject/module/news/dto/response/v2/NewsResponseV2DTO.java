package com.cefalo.newstestproject.module.news.dto.response.v2;


import com.cefalo.newstestproject.module.news.dto.generic.NewsV2DTO;
import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class NewsResponseV2DTO extends GenereicResponseDTO {

    @XmlElement(name = "news")
    private List<NewsV2DTO> news;

    public NewsResponseV2DTO() {
        super();
    }

    public NewsResponseV2DTO(String statusCode, String message, List<NewsV2DTO> news) {
        super(statusCode, message);
        this.news = news;
    }

    public NewsResponseV2DTO(String statusCode, String message) {
        super(statusCode, message);
    }

    public NewsResponseV2DTO(String statusCode, String message, String exceptionMessage) {
        super(statusCode, message, exceptionMessage);
    }


    public List<NewsV2DTO> getNews() {
        return news;
    }

    public void setNews(List<NewsV2DTO> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return super.toString() + " NewsResponseV2DTO{" +
                "news=" + news +
                '}';
    }
}
