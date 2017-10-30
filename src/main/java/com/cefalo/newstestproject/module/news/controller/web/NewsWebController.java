package com.cefalo.newstestproject.module.news.controller.web;

import org.springframework.ui.Model;

public interface NewsWebController {

    String showNews(Model newsUiModel);

    String showNewsById(int newsId, Model newsUiModel);
}
