package com.cefalo.newstestproject.module.news.service;

import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.repository.NewsRepositoryV1;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class NewsServiceV1ImplTest {

    private NewsServiceV1Impl newsService;

    private NewsRepositoryV1 newsRepositoryV1;

    @Before
    public void prepare() {
        newsRepositoryV1 = mock(NewsRepositoryV1.class);
        newsService = new NewsServiceV1Impl(newsRepositoryV1);
    }


    @Test
    public void test_GetNewsByTitle() throws Exception {
        List<NewsEntity> newsEntities = new ArrayList<>();
        newsEntities.add(new NewsEntity("A", "B", "AT"));
        when(newsRepositoryV1.findByNewsTitle("A")).thenReturn(newsEntities);
        assertEquals(newsService.getNewsByTitle("A"), newsEntities);
    }

    @Test
    public void test_GetNewsById() throws Exception {
        NewsEntity aNewsEntity = new NewsEntity("A", "B", "AT");
        when(newsRepositoryV1.findOne(0)).thenReturn(aNewsEntity);
        assertEquals(newsService.getNewsById(0), aNewsEntity);
    }


}