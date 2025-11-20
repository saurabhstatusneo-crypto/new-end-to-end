package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @InjectMocks
    private MathController mathController;

    @Mock
    private MathService mathService;

    @Test
    public void testMultiply() {
        when(mathService.multiply(2, 5)).thenReturn(10);
        assertEquals(10, mathController.multiply(2, 5));
    }

    @Test
    public void testDivide() {
        when(mathService.divide(10, 2)).thenReturn(5.0);
        assertEquals(5.0, mathController.divide(10, 2));
    }

    @Test
    public void testTable() {
        when(mathService.generateTable(2, 10)).thenReturn("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n2 x 6 = 12\n2 x 7 = 14\n2 x 8 = 16\n2 x 9 = 18\n2 x 10 = 20");
        assertEquals("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n2 x 6 = 12\n2 x 7 = 14\n2 x 8 = 16\n2 x 9 = 18\n2 x 10 = 20", mathController.table(2, 10));
    }

    @Test
    public void testCount() {
        when(mathService.countUpTo(10)).thenReturn("Counting 1 to 10: \n1\n2\n3\n4\n5\n6\n7\n8\n9\n10");
        assertEquals("Counting 1 to 10: \n1\n2\n3\n4\n5\n6\n7\n8\n9\n10", mathController.count(10));
    }
}