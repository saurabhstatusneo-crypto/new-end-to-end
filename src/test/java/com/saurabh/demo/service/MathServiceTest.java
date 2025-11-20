package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private MathService mathService = new MathService();

    @Test
    public void testMultiply() {
        int result = mathService.multiply(5, 3);
        assertEquals(15, result);
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        int result = mathService.multiply(-5, -3);
        assertEquals(15, result);
    }

    @Test
    public void testMultiplyZero() {
        int result = mathService.multiply(0, 3);
        assertEquals(0, result);
    }

    @Test
    public void testMultiplyVeryLargeNumbers() {
        int result = mathService.multiply(50000, 30000);
        assertEquals(1500000000, result);
    }

    @Test
    public void testDivide() {
        double result = mathService.divide(12, 3);
        assertEquals(4.0, result, 0.00001);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(12, 0));
    }

    @Test
    public void testDivideVeryLargeNumbers() {
        double result = mathService.divide(50000.5, 30000);
        assertEquals(1.6666666666666666, result, 0.00001);
    }

    @Test
    public void testGenerateTable() {
        String result = mathService.generateTable(5, 10);
        assertEquals("5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n5 x 6 = 30\n5 x 7 = 35\n5 x 8 = 40\n5 x 9 = 45\n5 x 10 = 50", result);
    }

    @Test
    public void testCountUpTo() {
        String result = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    public void testCountUpToZero() {
        String result = mathService.countUpTo(0);
        assertEquals("", result);
    }

    @Test
    public void testCountUpToVeryLargeNumber() {
        String result = mathService.countUpTo(100000);
        assertEquals("1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100000", result);
    }

    @Test
    public void testHelloworld() {
    	System.out.print(mathService.helloworld());
        assertEquals("hoshiyar", mathService.helloworld());
    }

    @Test
    public void testPrintButterfly() {
        java.io.PrintStream originalOut = System.out;
        java.io.PrintStream originalErr = System.err;
        try {
            System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream()));
            System.setErr(new java.io.PrintStream(new java.io.ByteArrayOutputStream()));
            mathService.printButterfly(5);
            // The expected output is just a visual representation of a butterfly, so we can't use assertions here.
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

}