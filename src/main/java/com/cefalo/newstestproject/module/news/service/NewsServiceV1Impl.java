package com.cefalo.newstestproject.module.news.service;

import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.repository.NewsRepositoryV1;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.util.List;

@Service
public class NewsServiceV1Impl implements NewsServiceV1 {

    private static Logger ourLogger = LogManager.getLogger(NewsServiceV1Impl.class);

    private NewsRepositoryV1 newsRepositoryV1;

    @Autowired
    public NewsServiceV1Impl(NewsRepositoryV1 newsRepositoryV1) {
        this.newsRepositoryV1 = newsRepositoryV1;
    }


    @Override
    public NewsEntity getNewsById(int newsId) throws ConnectException {
        NewsEntity newsEntity = newsRepositoryV1.findOne(newsId);
        return newsEntity;
    }

    @Override
    public List<NewsEntity> getNewsByTitle(String newsTitle) throws ConnectException {
        List<NewsEntity> allNews = newsRepositoryV1.findByNewsTitle(newsTitle);
        return allNews;
    }

    @Override
    public void createNews(NewsEntity newsEntity) throws ConnectException  {
        ourLogger.info("News to be saved : " + newsEntity.toString());
        newsRepositoryV1.save(newsEntity);
    }

    @Override
    public Iterable<NewsEntity> getAllNews() throws ConnectException {
        Iterable<NewsEntity> allNews = newsRepositoryV1.findAll();
        return allNews;
    }

    @Override
    public boolean isNewsExists(NewsEntity newsEntity) throws ConnectException {
        return !newsRepositoryV1.findByNewsTitle(newsEntity.getNewsTitle()).isEmpty();
    }

    @Override
    public GenereicResponseDTO getOrCreateNews (NewsEntity newsEntity) throws ConnectException {
        String responseMessage;
        // check if already a news with same title exists
        if (isNewsExists(newsEntity)) {
            responseMessage = "Unable to create. A News with the same title already exists. Title : " + newsEntity.getNewsTitle();
            ourLogger.error(responseMessage);
            return new GenereicResponseDTO(HttpStatus.CONFLICT.toString(), responseMessage);
        }
        // if not create the news
        createNews(newsEntity);
        responseMessage = "A news titled " + newsEntity.getNewsTitle() + " succesfully created";
        ourLogger.info(responseMessage);
        return new GenereicResponseDTO(HttpStatus.CREATED.toString(), responseMessage);
    }
}
