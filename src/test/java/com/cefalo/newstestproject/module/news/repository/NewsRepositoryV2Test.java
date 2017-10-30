package com.cefalo.newstestproject.module.news.repository;

import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class NewsRepositoryV2Test {

    private static Logger ourLogger = LogManager.getLogger(NewsRepositoryV2Test.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NewsRepositoryV2 newsRepositoryV2;

    @Test
    public void test_findByNewsId() throws Exception {
        NewsEntityV2 aNewsEntity = new NewsEntityV2("a","b","c",new Date(2017, 02, 11));
        entityManager.persist(aNewsEntity);
        ourLogger.info("News Entity is :" +  aNewsEntity.toString());
        NewsEntityV2 newsEntityRepository = newsRepositoryV2.findOne(aNewsEntity.getNewsId());
        assertEquals(aNewsEntity.getNewsId(), newsEntityRepository.getNewsId());

    }

    @Test
    public void test_findByNewsTitle() throws Exception {

        entityManager.persist(new NewsEntityV2("a","b","C",new Date(2017, 02, 11)));
        List<NewsEntityV2> newsEntities = newsRepositoryV2.findByNewsTitle("a");
        ourLogger.info("News Entity is :" +  newsEntities.get(0).toString());
        assertEquals("a", newsEntities.get(0).getNewsTitle());

    }



}