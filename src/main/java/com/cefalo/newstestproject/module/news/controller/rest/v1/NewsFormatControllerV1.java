package com.cefalo.newstestproject.module.news.controller.rest.v1;


import com.cefalo.newstestproject.module.news.dto.response.v1.NewsResponseV1DTO;


public interface NewsFormatControllerV1 {

    NewsResponseV1DTO showNewsById(int newsId);

}
