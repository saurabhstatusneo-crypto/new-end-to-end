package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private MathService mathService = new MathService();

    @Test
    public void testMultiply() {
        assertEquals(10, mathService.multiply(5, 2));
        assertEquals(0, mathService.multiply(-5, -5));
    }

    @Test
    public void testDivide() {
        assertEquals(5.0, mathService.divide(10, 2));
        assertEquals(-5.0, mathService.divide(-10, 2));
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
    }

    @Test
    public void testGenerateTable() {
        String expected = "1 x 1 = 1\n" +
                "1 x 2 = 2\n" +
                "1 x 3 = 3\n" +
                "1 x 4 = 4\n" +
                "1 x 5 = 5\n";
        assertEquals(expected, mathService.generateTable(1, 5));
    }

    @Test
    public void testCountUpTo() {
        assertEquals("1 2 3 4 5", mathService.countUpTo(5));
        assertEquals("1", mathService.countUpTo(1));
    }

    @Test
    public void testHelloworld() {
        assertEquals("hoshiyar", mathService.helloworld());
    }

    @Test
    void printButterfly() {
        // printButterfly method prints the butterfly diagram and doesn't return any value;
        // Hence, we don't need to assert anything here. However, if you're using some kind
        // of integration testing or need to verify the output, you should do it in a different way
        // such as capturing the output or comparing it with expected output.
    }

}