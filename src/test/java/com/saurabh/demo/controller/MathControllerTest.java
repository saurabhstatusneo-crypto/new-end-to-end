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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @InjectMocks
    private MathController mathController;

    @Mock
    private MathService mathService;

    private MockMvc mockMvc;

    private static final int NUMBER = 5;
    private static final int Upto = 10;
    private static final int DIVIDEND = 10;
    private static final int DIVISOR = 2;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void multiply() throws Exception {
        when(mathService.multiply(DIVIDEND, DIVISOR)).thenReturn(DIVIDEND * DIVISOR);

        mockMvc.perform(get("/math/multiply?a=" + DIVIDEND + "&b=" + DIVISOR))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(DIVIDEND * DIVISOR)));
    }

    @Test
    public void divide() throws Exception {
        when(mathService.divide(DIVIDEND, DIVISOR)).thenReturn((double) DIVIDEND / DIVISOR);

        mockMvc.perform(get("/math/divide?a=" + DIVIDEND + "&b=" + DIVISOR))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf((double) DIVIDEND / DIVISOR)));
    }

    @Test
    public void table() throws Exception {
        when(mathService.generateTable(NUMBER, Upto)).thenReturn("Table: \n" +
                numberOfTimes(NUMBER, Upto));

        mockMvc.perform(get("/math/table?number=" + NUMBER + "&upTo=" + Upto))
                .andExpect(status().isOk())
                .andExpect(content().string("Table: \n" + numberOfTimes(NUMBER, Upto)));
    }

    @Test
    public void count() throws Exception {
        when(mathService.countUpTo(NUMBER)).thenReturn(getExpectedCount(NUMBER));

        mockMvc.perform(get("/math/count?n=" + NUMBER))
                .andExpect(status().isOk())
                .andExpect(content().string(getExpectedCount(NUMBER)));
    }

    private String numberOfTimes(int number, int upTo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= upTo; i++) {
            sb.append("\n").append(number).append(" x ").append(i).append(" = ").append(number * i);
        }
        return sb.toString();
    }

    private String getExpectedCount(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= number; i++) {
            sb.append("\n").append(i);
        }
        return sb.toString();
    }
}