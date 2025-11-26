package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.RequestParam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @InjectMocks
    private MathController mathController;

    @Mock
    private MathService mathService;

    @Test
    void testMultiply() {
        when(mathService.multiply(5, 3)).thenReturn(15);
        int result = mathController.multiply(5, 3);
        assertEquals(15, result);
        verify(mathService).multiply(5, 3);
    }

    @Test
    void testDivide() {
        when(mathService.divide(10, 2)).thenReturn(5.0);
        double result = mathController.divide(10, 2);
        assertEquals(5.0, result);
        verify(mathService).divide(10, 2);
    }

    @Test
    void testTable() {
        when(mathService.generateTable(4, 10)).thenReturn("4 * 1 = 4\n");
        String result = mathController.table(4, 10);
        assertEquals("4 * 1 = 4\n", result);
        verify(mathService).generateTable(4, 10);
    }

    @Test
    void testCount() {
        when(mathService.countUpTo(5)).thenReturn("0, 1, 2, 3, 4, 5");
        String result = mathController.count(5);
        assertEquals("0, 1, 2, 3, 4, 5", result);
        verify(mathService).countUpTo(5);
    }

    @Test
    void testTableDefault() {
        when(mathService.generateTable(4, 5)).thenReturn("4 * 1 = 4\n4 * 2 = 8\n4 * 3 = 12\n4 * 4 = 16\n4 * 5 = 20");
        String result = mathController.table(4);
        assertEquals("4 * 1 = 4\n4 * 2 = 8\n4 * 3 = 12\n4 * 4 = 16\n4 * 5 = 20", result);
        verify(mathService).generateTable(4, 5);
    }
}