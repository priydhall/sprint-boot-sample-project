package com.cefalo.newstestproject.module.news.service;

import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;

import java.net.ConnectException;
import java.util.List;


public interface NewsServiceV2{

    NewsEntityV2 getNewsById(int newsId) throws ConnectException ;

    void createNews(NewsEntityV2 newsEntity) throws ConnectException ;

    Iterable<NewsEntityV2> getAllNews() throws ConnectException ;

    boolean isNewsExists(NewsEntityV2 newsEntity) throws ConnectException;

    GenereicResponseDTO getOrCreateNews(NewsEntityV2 newsEntity) throws ConnectException;

    List<NewsEntityV2> getNewsByTitle(String newsTitle) throws ConnectException;

}
