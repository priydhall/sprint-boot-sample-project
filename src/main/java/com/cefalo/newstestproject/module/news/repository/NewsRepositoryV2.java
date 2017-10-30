package com.cefalo.newstestproject.module.news.repository;

import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import org.hibernate.JDBCException;
import org.springframework.data.repository.CrudRepository;

import java.net.ConnectException;
import java.util.List;


public interface NewsRepositoryV2 extends CrudRepository<NewsEntityV2, Integer>{

    List<NewsEntityV2> findByNewsTitle(String newsTitle) throws JDBCException, ConnectException;

}
