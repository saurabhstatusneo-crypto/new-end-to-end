package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MathService mathService;

    @Autowired
    private MockMvc mockMvc;

    private Map<String, Object> mockMathService;

    @BeforeEach
    public void setup() {
        mockMathService = new HashMap<>();
        mockMathService.put("multiply", (a, b) -> a * b);
        mockMathService.put("divide", (a, b) -> a / (double) b);
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(get("/math/multiply?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(get("/math/divide?a=6&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    public void testTable() throws Exception {
        String table = mathService.generateTable(2, 5);
        mockMvc.perform(get("/math/table?number=2&upTo=5"))
                .andExpect(status().isOk())
                .andExpect(content().string(table));
    }

    @Test
    public void testCount() throws Exception {
        String count = mathService.countUpTo(10);
        mockMvc.perform(get("/math/count?n=10"))
                .andExpect(status().isOk())
                .andExpect(content().string(count));
    }
}