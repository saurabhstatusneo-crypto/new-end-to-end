package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @Mock
    private MathService mathService;

    private MathController mathController;

    @BeforeEach
    public void setup() {
        mathController = new MathController(mathService);
    }

    @Test
    public void testMultiply() {
        when(mathService.multiply(2, 3)).thenReturn(6);

        int result = mathController.multiply(2, 3);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        when(mathService.multiply(-2, -3)).thenReturn(6);

        int result = mathController.multiply(-2, -3);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void testMultiplyZero() {
        when(mathService.multiply(2, 0)).thenReturn(0);

        int result = mathController.multiply(2, 0);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testMultiplyLargeNumbers() {
        when(mathService.multiply(Integer.MAX_VALUE, 2)).thenReturn(Integer.MAX_VALUE * 2);

        int result = mathController.multiply(Integer.MAX_VALUE, 2);

        assertThat(result).isEqualTo(Integer.MAX_VALUE * 2);
    }

    @Test
    public void testDivide() {
        when(mathService.divide(8, 2)).thenReturn(4);

        double result = mathController.divide(8, 2);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void testDivideByZero() {
        when(mathService.divide(5, 0)).thenThrow(ArithmeticException.class);

        assertThrows(ArithmeticException.class, () -> mathController.divide(5, 0));
    }

    @Test
    public void testTable() {
        when(mathService.generateTable(2, 10)).thenReturn("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n2 x 6 = 12\n2 x 7 = 14\n2 x 8 = 16\n2 x 9 = 18\n2 x 10 = 20");

        String result = mathController.table(2, 10);

        assertThat(result).contains("2 x 1 = 2");
    }

    @Test
    public void testTableWithDefaultUpTo() {
        when(mathService.generateTable(2, 10)).thenReturn("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n2 x 6 = 12\n2 x 7 = 14\n2 x 8 = 16\n2 x 9 = 18\n2 x 10 = 20");

        String result = mathController.table(2, 5);

        assertThat(result).contains("2 x 1 = 2");
    }

    @Test
    public void testCount() {
        when(mathService.countUpTo(5)).thenReturn("1. 1\n2. 2\n3. 3\n4. 4\n5. 5");

        String result = mathController.count(5);

        assertThat(result).contains("1. 1");
    }
}