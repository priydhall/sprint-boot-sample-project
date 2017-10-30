package com.cefalo.newstestproject.module.news.controller.rest.v2;

import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;
import com.cefalo.newstestproject.module.news.dto.generic.NewsV2DTO;
import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;

public interface NewsRestControllerV2 {

    GenereicResponseDTO addNews(NewsV2DTO newsDTO);
    GenereicResponseDTO ping();
}
