package com.saurabh.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.saurabh.demo.model.MathResult;
import com.saurabh.demo.model.TableResult;
import com.saurabh.demo.service.MathService;
import com.saurabh.demo.service.MathServiceException;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @InjectMocks
    private MathController controller;

    @Mock
    private MathService mathService;

    @Test
    void testMultiply() {
        int a = 5;
        int b = 6;
        Integer expectedResult = 30;

        when(mathService.multiply(a, b)).thenReturn(expectedResult);
        int result = controller.multiply(a, b);
        assertEquals(expectedResult, result);
    }

    @Test
    void testMultiply_WithZero() {
        int a = 5;
        int b = 0;
        ZeroDivisionException expectedException = assertThrows(ZeroDivisionException.class, () -> controller.multiply(a, b));
        assertEquals("Division by zero", expectedException.getMessage());
    }

    @Test
    void testDivide() {
        int a = 10;
        int b = 2;
        Double expectedResult = 5.0;

        when(mathService.divide(a, b)).thenReturn(expectedResult);
        double result = controller.divide(a, b);
        assertEquals(expectedResult, result);
    }

    @Test
    void testDivide_WithZero() {
        int a = 10;
        int b = 0;
        ArithmeticException expectedException = assertThrows(ArithmeticException.class, () -> controller.divide(a, b));
        assertEquals("Cannot divide by zero", expectedException.getMessage());
    }

    @Test
    void testTable() {
        int number = 3;
        int upTo = 10;
        String expectedResult = "Multiplication Table for 3 up to 10: 3 * 1 = 3, 3 * 2 = 6, 3 * 3 = 9, 3 * 4 = 12, ...";

        when(mathService.generateTable(number, upTo)).thenReturn(expectedResult);
        String result = controller.table(number, upTo);
        assertEquals(expectedResult, result);
    }

    @Test
    void testTable_WithNegativeNumber() {
        int number = -3;
        int upTo = 10;
        String expectedResult = "";

        when(mathService.generateTable(number, upTo)).thenReturn(expectedResult);
        String result = controller.table(number, upTo);
        assertEquals(expectedResult, result);
    }

    @Test
    void testCount() {
        int n = 5;
        String expectedResult = "Count up to 5: 1, 2, 3, 4, 5";

        when(mathService.countUpTo(n)).thenReturn(expectedResult);
        String result = controller.count(n);
        assertEquals(expectedResult, result);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        reset(mathService);
    }
}

class ZeroDivisionException extends ArithmeticException {}

class ArithmeticException extends Exception {}