package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MathService mathService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMultiply() throws Exception {
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/math/multiply?a=5&b=6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("30"))
                .andReturn().getResponse().getContentAsString();
        assertThat(Integer.parseInt(responseBody), is(30));
    }

    @Test
    void testDivide() throws Exception {
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/math/divide?a=6&b=3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("2.0"))
                .andReturn().getResponse().getContentAsString();
        assertThat(Double.parseDouble(responseBody), is(2.0));
    }

    @Test
    void testTable() throws Exception {
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/math/table?number=2&upTo=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(responseBody, is("2 x 1 = 2 \n2 x 2 = 4 \n2 x 3 = 6 \n2 x 4 = 8 \n2 x 5 = 10 "));
    }

    @Test
    void testCount() throws Exception {
        String responseBody = mockMvc.perform(MockMvcRequestBuilders.get("/math/count?n=5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertThat(responseBody, is("12345"));
    }

}