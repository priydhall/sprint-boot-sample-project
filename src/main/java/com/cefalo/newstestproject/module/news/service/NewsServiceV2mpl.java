package com.cefalo.newstestproject.module.news.service;

import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import com.cefalo.newstestproject.module.news.repository.NewsRepositoryV2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.util.List;

@Service
public class NewsServiceV2mpl implements NewsServiceV2 {

    private static Logger ourLogger = LogManager.getLogger(NewsServiceV2mpl.class);

    private NewsRepositoryV2 newsRepositoryV2;

    @Autowired
    public NewsServiceV2mpl(NewsRepositoryV2 newsRepositoryV2) {
        this.newsRepositoryV2 = newsRepositoryV2;
    }


    @Override
    public NewsEntityV2 getNewsById(int newsId) throws ConnectException {
        NewsEntityV2 newsEntity = newsRepositoryV2.findOne(newsId);
        return newsEntity;
    }

    @Override
    public List<NewsEntityV2> getNewsByTitle(String newsTitle) throws ConnectException {
        List<NewsEntityV2> allNews = newsRepositoryV2.findByNewsTitle(newsTitle);
        return allNews;
    }

    @Override
    public void createNews(NewsEntityV2 newsEntity) throws ConnectException  {
        ourLogger.info("News to be saved : " + newsEntity.toString());
        newsRepositoryV2.save(newsEntity);
    }

    @Override
    public Iterable<NewsEntityV2> getAllNews() throws ConnectException {
        Iterable<NewsEntityV2> allNews = newsRepositoryV2.findAll();
        return allNews;
    }

    @Override
    public boolean isNewsExists(NewsEntityV2 newsEntity) throws ConnectException {
        return !newsRepositoryV2.findByNewsTitle(newsEntity.getNewsTitle()).isEmpty();
    }

    @Override
    public GenereicResponseDTO getOrCreateNews (NewsEntityV2 newsEntity) throws ConnectException {
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
