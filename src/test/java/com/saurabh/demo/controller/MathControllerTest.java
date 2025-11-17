package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MathController mathController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MathService mathService;

    @Test
    public void testMultiply() throws Exception {
        // Arrange
        int a = 4;
        int b = 5;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/math/multiply")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(a * b)));
    }

    @Test
    public void testDivide() throws Exception {
        // Arrange
        int a = 10;
        int b = 2;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/math/divide")
                .param("a", String.valueOf(a))
                .param("b", String.valueOf(b)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(a / (double) b)));
    }

    @Test
    public void testTable() throws Exception {
        // Arrange
        int number = 3;
        int upTo = 10;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/math/table")
                .param("number", String.valueOf(number))
                .param("upTo", String.valueOf(upTo)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCount() throws Exception {
        // Arrange
        int n = 5;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/math/count")
                .param("n", String.valueOf(n)))
                .andExpect(status().isOk());
    }
}