package com.cefalo.newstestproject.module.news.controller.rest.v2;

import com.cefalo.newstestproject.module.news.service.NewsServiceV2;
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



@RunWith(SpringRunner.class)
@WebMvcTest(NewsFormatControllerV2Impl.class)
public class NewsFormatControllerV2ImplTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private NewsServiceV2 newsService;


    @Test
    public void testNewsFormat() throws Exception {
        int newsId = 1;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/news/json/{newsId}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}