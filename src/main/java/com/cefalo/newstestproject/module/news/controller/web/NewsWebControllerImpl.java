package com.cefalo.newstestproject.module.news.controller.web;

import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;
import com.cefalo.newstestproject.module.news.dto.generic.NewsV2DTO;
import com.cefalo.newstestproject.module.news.dto.response.v1.NewsResponseV1DTO;
import com.cefalo.newstestproject.module.news.dto.response.v2.NewsResponseV2DTO;
import com.cefalo.newstestproject.module.news.entity.NewsEntity;
import com.cefalo.newstestproject.module.news.entity.NewsEntityV2;
import com.cefalo.newstestproject.module.news.service.NewsServiceV1;
import com.cefalo.newstestproject.module.news.service.NewsServiceV2;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;


@Controller
public class NewsWebControllerImpl implements NewsWebController {
    private static Logger ourLogger = LogManager.getLogger(NewsWebControllerImpl.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewsServiceV2 newsService;


    @Override
    @RequestMapping(value = "/news/",
            method = RequestMethod.GET)
    public String showNews(Model newsUiModel) {
        String responseMessage;
        try {
            List<NewsEntityV2> allNewsEntities = (List<NewsEntityV2>) newsService.getAllNews();
            // check if any news created yet
            if (allNewsEntities.size() == 0) {
                responseMessage = "No news has been created yet !!!";
                ourLogger.info(responseMessage);
                newsUiModel.addAttribute("newsResponse", new NewsResponseV2DTO(HttpStatus.NO_CONTENT.toString(), responseMessage));
                return "allnews";
            }
            // if there are already created news show them
            // Mapping entities to dto
            List<NewsV2DTO> newsDTO = modelMapper.map(allNewsEntities, List.class);
            responseMessage = "Total number of news created so far : " + newsDTO.size();
            newsUiModel.addAttribute("newsResponse", new NewsResponseV2DTO(HttpStatus.OK.toString(), responseMessage, newsDTO));
            ourLogger.info(responseMessage);
            return "allnews";
        } catch (Exception ex) {
            newsErrorProcess(newsUiModel, ex);
            return "allnews";
        }
    }

    @Override
    @RequestMapping(value = "/news/{newsId}",
            method = RequestMethod.GET)
    public String showNewsById(@PathVariable(value = "newsId") int newsId,
                               Model newsUiModel) {
        String responseMessage;
        try {
            NewsEntity aNewsEntity = newsService.getNewsById(newsId);
            // if no news found for the respective newsid
            if (aNewsEntity == null) {
                responseMessage = "News with id : " + newsId + " not found !!!";
                ourLogger.info(responseMessage);
                newsUiModel.addAttribute("newsResponse", new NewsResponseV2DTO(HttpStatus.NO_CONTENT.toString(), responseMessage));
                return "detailnews";
            }
            // if news found
            List<NewsV2DTO> newsDTO = new ArrayList<>();
            newsDTO.add(modelMapper.map(aNewsEntity, NewsV2DTO.class));
            responseMessage = "News details for id : " + newsId;
            newsUiModel.addAttribute("newsResponse", new NewsResponseV2DTO(HttpStatus.OK.toString(), responseMessage, newsDTO));
            ourLogger.info(responseMessage);
            return "detailnews";
        } catch (Exception ex) {
            newsErrorProcess(newsUiModel, ex);
            return "detailnews";
        }
    }

    private void newsErrorProcess(Model newsUiModel, Exception ex) {
        String responseMessage;
        responseMessage = "Internal Server Error. Try Again Later !!!";
        ourLogger.info(ex.getMessage(), ex);
        newsUiModel.addAttribute("newsResponse",  new NewsResponseV1DTO(HttpStatus.INTERNAL_SERVER_ERROR.toString(), responseMessage));
    }
}

