package com.cefalo.newstestproject.module.news.service;

import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;

import java.net.ConnectException;
import java.util.List;


public interface NewsServiceV1 {

    NewsEntity getNewsById(int newsId) throws ConnectException ;

    void createNews(NewsEntity newsEntity) throws ConnectException ;

    Iterable<NewsEntity> getAllNews() throws ConnectException ;

    boolean isNewsExists(NewsEntity newsEntity) throws ConnectException;

    GenereicResponseDTO getOrCreateNews(NewsEntity newsEntity) throws ConnectException;

    List<NewsEntity> getNewsByTitle(String newsTitle) throws ConnectException;




}
