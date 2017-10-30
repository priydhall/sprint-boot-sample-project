package com.cefalo.newstestproject.module.news.controller.rest.v2;

import com.cefalo.newstestproject.module.news.dto.generic.NewsV2DTO;
import com.cefalo.newstestproject.module.news.service.NewsServiceV2;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Date;


@RunWith(SpringRunner.class)
@WebMvcTest(NewsRestControllerV2Impl.class)
public class NewsRestControllerV2ImplTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private NewsServiceV2 newsService;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAddNews() throws Exception {
        NewsV2DTO newsDTO = new NewsV2DTO("a", "b", "c", new Date(2017, 02, 11));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v2/news/")
                .content(asJsonString(newsDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}