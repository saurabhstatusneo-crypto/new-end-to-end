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
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void testMultiply() throws Exception {
        when(mathService.multiply(5, 3)).thenReturn(15);
        mockMvc.perform(get("/math/multiply?a=5&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }

    @Test
    public void testDivide() throws Exception {
        when(mathService.divide(10, 2)).thenReturn(5);
        mockMvc.perform(get("/math/divide?a=10&b=2")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testTable() throws Exception {
        when(mathService.generateTable(3, 10)).thenReturn("3 x 1 = 3\n3 x 2 = 6\n3 x 3 = 9\n3 x 4 = 12\n3 x 5 = 15\n3 x 6 = 18\n3 x 7 = 21\n3 x 8 = 24\n3 x 9 = 27\n3 x 10 = 30");
        mockMvc.perform(get("/math/table?number=3&upTo=10")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3 x 1 = 3\n3 x 2 = 6\n3 x 3 = 9\n3 x 4 = 12\n3 x 5 = 15\n3 x 6 = 18\n3 x 7 = 21\n3 x 8 = 24\n3 x 9 = 27\n3 x 10 = 30"));
    }

    @Test
    public void testCount() throws Exception {
        when(mathService.countUpTo(5)).thenReturn("0 is not 2, 1 is not 2, 2 is 2, 3 is not 2, 4 is not 2, 5 is not 2");
        mockMvc.perform(get("/math/count?n=5")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("0 is not 2, 1 is not 2, 2 is 2, 3 is not 2, 4 is not 2, 5 is not 2"));
    }
}