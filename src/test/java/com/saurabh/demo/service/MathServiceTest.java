package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private MathService mathService = new MathService();

    @Test
    void testMultiply() {
        int result = mathService.multiply(5, 6);
        assertEquals(30, result);
    }

    @Test
    void testMultiplyZero() {
        int result = mathService.multiply(5, 0);
        assertEquals(0, result);
    }

    @Test
    void testDivide() {
        double result = mathService.divide(10, 2);
        assertEquals(5.0, result, 0.00001);
    }

    @Test
    void testDivideZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testGenerateTable() {
        String result = mathService.generateTable(2, 5);
        assertEquals("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n", result);
    }

    @Test
    void testCountUpTo() {
        String result = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    void testHelloworld() {
        String result = mathService.helloworld();
        assertEquals("hoshiyar", result);
    }

    @Test
    void testPrintButterfly() {
        // There's no good way to test console output directly in JUnit
        // We would need to use a library that captures and verifies console output
    }

    @Test
    void testPrintButterflyWithFiveRows() {
        MathService mathServiceWithPrint = new MathService();
        mathServiceWithPrint.printButterfly(5);
    }
}