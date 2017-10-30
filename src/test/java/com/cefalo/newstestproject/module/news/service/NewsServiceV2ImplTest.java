package com.cefalo.newstestproject.module.news.service;

import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import com.cefalo.newstestproject.module.news.repository.NewsRepositoryV1;
import com.cefalo.newstestproject.module.news.repository.NewsRepositoryV2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
public class NewsServiceV2ImplTest {

    private NewsServiceV2mpl newsService;

    private NewsRepositoryV2 newsRepositoryV2;

    @Before
    public void prepare() {
        newsRepositoryV2 = mock(NewsRepositoryV2.class);
        newsService = new NewsServiceV2mpl(newsRepositoryV2);
    }


    @Test
    public void test_GetNewsByTitle() throws Exception {
        List<NewsEntityV2> newsEntities = new ArrayList<>();
        newsEntities.add(new NewsEntityV2("A", "B", "AT",new Date(2017, 02, 11)));
        when(newsRepositoryV2.findByNewsTitle("A")).thenReturn(newsEntities);
        assertEquals(newsService.getNewsByTitle("A"), newsEntities);
    }

    @Test
    public void test_GetNewsById() throws Exception {
        NewsEntityV2 aNewsEntity = new NewsEntityV2("A", "B", "AT",new Date(2017, 02, 11));
        when(newsRepositoryV2.findOne(0)).thenReturn(aNewsEntity);
        assertEquals(newsService.getNewsById(0), aNewsEntity);
    }


}