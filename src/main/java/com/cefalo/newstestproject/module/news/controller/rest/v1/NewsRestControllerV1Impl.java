package com.cefalo.newstestproject.module.news.controller.rest.v1;

import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;
import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.service.NewsServiceV1;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1")
public class NewsRestControllerV1Impl implements NewsRestControllerV1 {
    private static Logger ourLogger = LogManager.getLogger(NewsRestControllerV1Impl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewsServiceV1 newsServiceV1;


    @Override
    @RequestMapping(method = RequestMethod.POST,
            value = "/news/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenereicResponseDTO addNews(@RequestBody NewsV1DTO newsV1DTO) {
        String responseMessage;
        try {
            ourLogger.info("Received news create request : " + newsV1DTO.toString());
            NewsEntity newsEntity = modelMapper.map(newsV1DTO, NewsEntity.class);
            return newsServiceV1.getOrCreateNews(newsEntity);
        } catch (ConstraintViolationException ex) {
            ourLogger.error(ex.getMessage(), ex);
            responseMessage = "Wrong Input Given";
            return new GenereicResponseDTO(HttpStatus.BAD_REQUEST.toString(), responseMessage,ex.getMessage());
        } catch (Exception ex) {
            ourLogger.error(ex.getMessage(), ex);
            responseMessage = "Internal Server Error. Try again later";
            return new GenereicResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), responseMessage, ex.getMessage());
        }
    }


    @Override
    @RequestMapping(method = RequestMethod.GET,
            value = "/ping/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenereicResponseDTO ping() {
        String responseMessage = "API V1 is up and running.";
        ourLogger.info("Received ping request. " );
        return new GenereicResponseDTO(HttpStatus.OK.toString(), responseMessage, "No Exception");
    }
}

