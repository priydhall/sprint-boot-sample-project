package com.cefalo.newstestproject.module.news.controller.rest.v2;


import com.cefalo.newstestproject.module.news.dto.response.v2.NewsResponseV2DTO;

public interface NewsFormatControllerV2 {

    NewsResponseV2DTO showNewsById(int newsId);

    NewsResponseV2DTO showNewsByIdXML(int newsId);

}
