package com.cefalo.newstestproject.module.news.repository;

import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import org.hibernate.JDBCException;
import org.springframework.data.repository.CrudRepository;

import java.net.ConnectException;
import java.util.List;


public interface NewsRepositoryV1 extends CrudRepository<NewsEntity, Integer>{

    List<NewsEntity> findByNewsTitle(String newsTitle) throws JDBCException, ConnectException;

}
