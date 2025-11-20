package com.saurabh.demo.controller.test;

import com.saurabh.demo.controller.MathController;
import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @Mock
    private MathService mathService;

    @Mock
    private MappingJackson2HttpMessageConverter jsonConverter;

    @InjectMocks
    private MathController mathController;

    private MockMvc mockMvc;

    @Test
    public void testMultiply() throws Exception {
        when(mathService.multiply(any(Integer.class), any(Integer.class))).thenReturn(20);
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/multiply?a=4&b=5"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.result").value(20));
    }

    @Test
    public void testDivide() throws Exception {
        when(mathService.divide(any(Integer.class), any(Integer.class))).thenReturn(2.0);
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/divide?a=10&b=5"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.result").value(2.0));
    }

    @Test
    public void testTable() throws Exception {
        when(mathService.generateTable(any(Integer.class), any(Integer.class))).thenReturn("Table of 5 from 1 to 10:");
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/table?number=5&upTo=10"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.result").value("Table of 5 from 1 to 10:"));
    }

    @Test
    public void testCount() throws Exception {
        when(mathService.countUpTo(any(Integer.class))).thenReturn("Count from 0 to 10:");
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/count?n=10"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.result").value("Count from 0 to 10:"));
    }

    @Test
    public void testNegativeInput() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/multiply?a=-5&b=-3"))
                .andExpect(status().is(400));
    }

    @Test
    public void testDivisionByZero() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/divide?a=10&b=0"))
                .andExpect(status().is(400));
    }
}