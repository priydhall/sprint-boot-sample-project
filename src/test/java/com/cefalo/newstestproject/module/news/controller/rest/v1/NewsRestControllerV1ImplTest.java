package com.cefalo.newstestproject.module.news.controller.rest.v1;

import com.cefalo.newstestproject.module.news.controller.rest.v1.NewsRestControllerV1Impl;
import com.cefalo.newstestproject.module.news.dto.generic.NewsV1DTO;
import com.cefalo.newstestproject.module.news.service.NewsServiceV1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.cefalo.newstestproject.module.news.controller.rest.v2.NewsRestControllerV2ImplTest.asJsonString;


@RunWith(SpringRunner.class)
@WebMvcTest(NewsRestControllerV1Impl.class)
public class NewsRestControllerV1ImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private NewsServiceV1 newsService;


    @Test
    public void testAddNews() throws Exception {
        NewsV1DTO newsDTO = new NewsV1DTO("a", "b", "c");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/news/")
                .content(asJsonString(newsDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}