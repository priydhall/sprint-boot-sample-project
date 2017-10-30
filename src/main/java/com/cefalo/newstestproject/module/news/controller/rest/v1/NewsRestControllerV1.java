package com.cefalo.newstestproject.module.news.controller.rest.v1;

import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;

public interface NewsRestControllerV1 {

    GenereicResponseDTO addNews(NewsV1DTO newDTO);
    GenereicResponseDTO ping();
}
