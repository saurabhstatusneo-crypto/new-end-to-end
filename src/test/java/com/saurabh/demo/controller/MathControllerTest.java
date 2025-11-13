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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @Mock
    private MathService mathService;

    @InjectMocks
    private MathController mathController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void testMultiply() throws Exception {
        int a = 5;
        int b = 10;
        int expected = 50;
        when(mathService.multiply(a, b)).thenReturn(expected);

        mockMvc.perform(get("/math/multiply?a=" + a + "&b=" + b))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected)));
    }

    @Test
    public void testDivide() throws Exception {
        int a = 10;
        int b = 2;
        double expected = 5.0;
        when(mathService.divide(a, b)).thenReturn(expected);

        mockMvc.perform(get("/math/divide?a=" + a + "&b=" + b))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected)));
    }

    @Test
    public void testTable() throws Exception {
        int number = 5;
        int upTo = 10;
        String expected = "Table for 5:\n" +
                "5 x 1 = 5\n" +
                "5 x 2 = 10\n" +
                "5 x 3 = 15\n" +
                "5 x 4 = 20\n" +
                "5 x 5 = 25\n" +
                "5 x 6 = 30\n" +
                "5 x 7 = 35\n" +
                "5 x 8 = 40\n" +
                "5 x 9 = 45\n" +
                "5 x 10 = 50";
        when(mathService.generateTable(number, upTo)).thenReturn(expected);

        mockMvc.perform(get("/math/table?number=" + number + "&upTo=" + upTo))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testCount() throws Exception {
        int n = 5;
        String expected = "Counting up to 5:\n1.\n2.\n3.\n4.\n5.\nThere are 5 steps.";
        when(mathService.countUpTo(n)).thenReturn(expected);

        mockMvc.perform(get("/math/count?n=" + n))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

}