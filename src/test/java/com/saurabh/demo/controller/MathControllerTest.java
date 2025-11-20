package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @Mock
    private MathService mathService;

    @InjectMocks
    private MathController mathController;

    private MockMvc mockMvc;

    @Test
    public void testMultiply() throws Exception {
        when(mathService.multiply(2, 3)).thenReturn(6);
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/multiply?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void testDivide() throws Exception {
        when(mathService.divide(6, 2)).thenReturn(3.0);
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/divide?a=6&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    public void testTable() throws Exception {
        when(mathService.generateTable(2, 10)).thenReturn("2*1=2, 2*2=4, 2*3=6, 2*4=8, 2*5=10, 2*6=12, 2*7=14, 2*8=16, 2*9=18, 2*10=20");
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/table?number=2&upTo=10"))
                .andExpect(status().isOk())
                .andExpect(content().string("2*1=2, 2*2=4, 2*3=6, 2*4=8, 2*5=10, 2*6=12, 2*7=14, 2*8=16, 2*9=18, 2*10=20"));
    }

    @Test
    public void testCount() throws Exception {
        when(mathService.countUpTo(2)).thenReturn("1, 2");
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
        mockMvc.perform(get("/math/count?n=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1, 2"));
    }
}