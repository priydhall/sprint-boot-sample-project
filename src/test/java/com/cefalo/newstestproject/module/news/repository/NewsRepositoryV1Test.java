package com.cefalo.newstestproject.module.news.repository;

import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class NewsRepositoryV1Test {

    private static Logger ourLogger = LogManager.getLogger(NewsRepositoryV1Test.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private NewsRepositoryV1 newsRepositoryV1;

    @Test
    public void test_findByNewsId() throws Exception {
        NewsEntity aNewsEntity = new NewsEntity("a","b","c");
        entityManager.persist(aNewsEntity);
        ourLogger.info("News Entity is :" +  aNewsEntity.toString());
        NewsEntity newsEntityRepository = newsRepositoryV1.findOne(aNewsEntity.getNewsId());
        assertEquals(aNewsEntity.getNewsId(), newsEntityRepository.getNewsId());

    }

    @Test
    public void test_findByNewsTitle() throws Exception {

        entityManager.persist(new NewsEntity("a","b","C"));
        List<NewsEntity> newsEntities = newsRepositoryV1.findByNewsTitle("a");
        ourLogger.info("News Entity is :" +  newsEntities.get(0).toString());
        assertEquals("a", newsEntities.get(0).getNewsTitle());

    }



}