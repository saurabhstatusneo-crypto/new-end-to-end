package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private MathService mathService = new MathService();

    @Test
    void testMultiply() {
        assertEquals(6, mathService.multiply(2, 3));
    }

    @Test
    void testMultiplyWithNegativeNumbers() {
        assertEquals(-6, mathService.multiply(-2, 3));
    }

    @Test
    void testMultiplyWithZero() {
        assertEquals(0, mathService.multiply(5, 0));
    }

    @Test
    void testDivide() {
        assertEquals(2, mathService.divide(6, 3), 0.1);
    }

    @Test
    void testDivideWithZero() {
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(5, 0));
    }

    @Test
    void testDivideWithNegativeNumbers() {
        assertEquals(-2, mathService.divide(-6, 3), 0.1);
    }

    @Test
    void testGenerateTable() {
        assertEquals("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n", mathService.generateTable(2, 3));
    }

    @Test
    void testGenerateTableWithHigherUpTo() {
        assertEquals("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n", mathService.generateTable(2, 5));
    }

    @Test
    void testCountUpTo() {
        assertEquals("1 2 3 4", mathService.countUpTo(5));
    }

    @Test
    void testCountUpToHigherNumber() {
        assertEquals("1 2 3 4 5 6 7 8 9 10", mathService.countUpTo(10));
    }

    // Note: The following test will only print to console, so it's not possible to assert its result.
    // If you want to verify its return value, consider printing to a StringBuffer or String.
    @Test
    public void testHelloworld() {
        mathService.helloworld();
    }

    @Test
    public void testPrintButterfly() {
        mathService.printButterfly(5);
    }
}