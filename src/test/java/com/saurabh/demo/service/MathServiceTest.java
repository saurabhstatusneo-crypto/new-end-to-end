package com.saurabh.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private final MathService mathService = new MathService();

    @Test
    public void testMultiply() {
        int result = mathService.multiply(5, 10);
        Assertions.assertEquals(50, result);
    }

    @Test
    public void testMultiplyZero() {
        int result = mathService.multiply(5, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testMultiplyNegative() {
        int result = mathService.multiply(-5, 10);
        Assertions.assertEquals(-50, result);
    }

    @Test
    public void testDivide() {
        double result = mathService.divide(10, 2);
        Assertions.assertEquals(5, result, 0.01);
    }

    @Test
    public void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
        Assertions.assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    public void testDivideNegative() {
        double result = mathService.divide(-10, 2);
        Assertions.assertEquals(-5, result, 0.01);
    }

    @Test
    public void testDivideFloat() {
        double result = mathService.divide(10.5, 2);
        Assertions.assertEquals(5.25, result, 0.01);
    }

    @Test
    public void testGenerateTable() {
        String result = mathService.generateTable(5, 10);
        Assertions.assertTrue(result.contains("5 x 1 = 5"));
        Assertions.assertTrue(result.contains("5 x 10 = 50"));
    }

    @Test
    public void testGenerateTableNegative() {
        String result = mathService.generateTable(-5, 10);
        Assertions.assertTrue(result.contains("-5 x 1 = -5"));
        Assertions.assertTrue(result.contains("-5 x 10 = -50"));
    }

    @Test
    public void testCountUpTo() {
        StringBuilder sb = new StringBuilder();
        sb.append("1 2 3 4 5").toString();
        String result = mathService.countUpTo(5);
        Assertions.assertEquals(sb.toString(), result);
    }

    @Test
    public void testCountUpToNegative() {
        StringBuilder sb = new StringBuilder();
        sb.append("-1 -2 -3 -4 -5").toString();
        String result = mathService.countUpTo(-5);
        Assertions.assertEquals(sb.toString(), result);
    }

    @Test
    public void testHelloWorld() {
        String result = mathService.helloworld();
        Assertions.assertEquals("hoshiyar", result);
    }

    @Test
    public void testPrintButterfly() {
        mathService.printButterfly(5);
        // This test only checks for the absence of any compilation errors
        // As printing the butterfly pattern is not an unit test
    }
}