package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MathService mathService;

    @ InjectMocks
    private MathController mathController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void testMultiply() throws Exception {
        when(mathService.multiply(anyInt(), anyInt())).thenReturn(10);
        ResponseEntity<Integer> response = new ResponseEntity<>(mathController.multiply(2, 5), HttpStatus.OK);
        this.mockMvc.perform(get("/math/multiply?a=2&b=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
        verify(mathService, times(1)).multiply(eq(2), eq(5));
    }

    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> mathController.divide(10, 0));
    }

    @Test
    public void testDivide() throws Exception {
        when(mathService.divide(anyInt(), anyInt())).thenReturn(2.0);
        ResponseEntity<Double> response = new ResponseEntity<>(mathController.divide(10, 5), HttpStatus.OK);
        this.mockMvc.perform(get("/math/divide?a=10&b=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
        verify(mathService, times(1)).divide(eq(10), eq(5));
    }

    @Test
    public void testTable() throws Exception {
        when(mathService.generateTable(anyInt(), anyInt())).thenReturn("1234567890");
        ResponseEntity<String> response = new ResponseEntity<>(mathController.table(1, 10), HttpStatus.OK);
        this.mockMvc.perform(get("/math/table?number=1&upTo=10"))
                .andExpect(status().isOk())
                .andExpect(content().string("1234567890"));
        verify(mathService, times(1)).generateTable(eq(1), eq(10));
    }

    @Test
    public void testCount() throws Exception {
        when(mathService.countUpTo(anyInt())).thenReturn("123456789");
        ResponseEntity<String> response = new ResponseEntity<>(mathController.count(10), HttpStatus.OK);
        this.mockMvc.perform(get("/math/count?n=10"))
                .andExpect(status().isOk())
                .andExpect(content().string("123456789"));
        verify(mathService, times(1)).countUpTo(eq(10));
    }
}