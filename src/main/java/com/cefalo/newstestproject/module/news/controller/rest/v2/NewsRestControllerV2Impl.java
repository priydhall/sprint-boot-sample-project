package com.cefalo.newstestproject.module.news.controller.rest.v2;

import com.cefalo.newstestproject.module.news.dto.generic.NewsV2DTO;
import com.cefalo.newstestproject.module.news.dto.response.GenereicResponseDTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import com.cefalo.newstestproject.module.news.service.NewsServiceV2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v2")
public class NewsRestControllerV2Impl implements NewsRestControllerV2 {
    private static Logger ourLogger = LogManager.getLogger(NewsRestControllerV2Impl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewsServiceV2 newsService;


    @Override
    @RequestMapping(method = RequestMethod.POST,
            value = "/news/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public GenereicResponseDTO addNews(@RequestBody NewsV2DTO newsDTO) {
        String responseMessage;
        try {
            ourLogger.info("Received news create request : " + newsDTO.toString());
            NewsEntityV2 newsEntity = modelMapper.map(newsDTO, NewsEntityV2.class);
            return newsService.getOrCreateNews(newsEntity);
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
        String responseMessage = "API V2 is up and running.";
        ourLogger.info("Received ping request. " );
        return new GenereicResponseDTO(HttpStatus.OK.toString(), responseMessage, "No Exception");
    }
}

