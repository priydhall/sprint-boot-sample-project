package com.cefalo.newstestproject.module.news.controller.rest.v1;

import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;
import com.cefalo.newstestproject.module.news.dto.response.v1.NewsResponseV1DTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.service.NewsServiceV1;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class NewsFormatControllerV1Impl implements NewsFormatControllerV1 {

    private static Logger ourLogger = LogManager.getLogger(NewsFormatControllerV1Impl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewsServiceV1 newsService;


    @Override
    @RequestMapping(method = RequestMethod.GET,
            value = "/news/json/{newsId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public NewsResponseV1DTO showNewsById(@PathVariable(value = "newsId") int newsId) {

        String responseMessage;
        NewsResponseV1DTO aNewsDTO;
        try {
            ourLogger.info("Received news details request : id [ " + newsId + " ] format [ json ]");
            NewsEntity aNewsEntity = newsService.getNewsById(newsId);
            if (aNewsEntity == null) {
                responseMessage = "News with id : " + newsId + " not found !!!";
                ourLogger.info(responseMessage);
                aNewsDTO = new NewsResponseV1DTO(HttpStatus.NO_CONTENT.toString(), responseMessage);
            } else {
                List<NewsV1DTO> newsDTO = new ArrayList<>();
                newsDTO.add(modelMapper.map(aNewsEntity, NewsV1DTO.class));
                responseMessage = "News details for id : " + newsId;
                ourLogger.info(responseMessage);
                aNewsDTO = new NewsResponseV1DTO(HttpStatus.OK.toString(), responseMessage, newsDTO);
            }
        } catch (Exception ex) {
            aNewsDTO = newsErrorProcess(ex);
        }

        return aNewsDTO;
    }


    private NewsResponseV1DTO newsErrorProcess(Exception ex) {
        String responseMessage;
        responseMessage = "Internal Server Error. Try Again Later !!!";
        ourLogger.info(ex.getMessage(), ex);
        return new NewsResponseV1DTO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), responseMessage,ex.getMessage());
    }

}
