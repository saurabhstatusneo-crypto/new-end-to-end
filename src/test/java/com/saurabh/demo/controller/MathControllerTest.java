package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MathService mathService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMultiply() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/math/multiply?a=5&b=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    void testDivision() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/math/divide?a=10&b=2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testTable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/math/table?number=5&upTo=10")
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(mathService.generateTable(5, 10)));
    }

    @Test
    void testTableDefaultUpTo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/math/table?number=5")
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(mathService.generateTable(5, 10)));
    }

    @Test
    void testCounting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/math/count?n=10")
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(mathService.countUpTo(10)));
    }
}