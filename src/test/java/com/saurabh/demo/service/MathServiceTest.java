package com.saurabh.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    private MathService mathService;

    @BeforeEach
    public void setup() {
        mathService = new MathService();
    }

    @Test
    public void testMultiply() {
        assertEquals(6, mathService.multiply(2, 3));
        assertEquals(-4, mathService.multiply(-2, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, mathService.divide(4, 2), 0.01);
        assertEquals(-1.5, mathService.divide(-3, 2), 0.01);
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(4, 0));
    }

    @Test
    public void testGenerateTable() {
        assertEquals("1 x 1 = 1\n2 x 1 = 2\n3 x 1 = 3\n4 x 1 = 4\n5 x 1 = 5\n6 x 1 = 6\n7 x 1 = 7\n8 x 1 = 8\n9 x 1 = 9\n10 x 1 = 10\n",
                mathService.generateTable(1, 10));
        assertEquals("1 x 2 = 2\n2 x 2 = 4\n3 x 2 = 6\n4 x 2 = 8\n5 x 2 = 10\n6 x 2 = 12\n7 x 2 = 14\n8 x 2 = 16\n9 x 2 = 18\n10 x 2 = 20\n",
                mathService.generateTable(2, 10));
    }

    @Test
    public void testCountUpTo() {
        assertEquals("1 2 3 4 5 ", mathService.countUpTo(5));
        assertEquals("1 2 3 4 5 6 7 8 9 10 ", mathService.countUpTo(10));
    }

    @Test
    public void testHelloWorld() {
        assertEquals("hoshiyar", mathService.helloworld());
    }

    // Note: printButterfly method does not return anything, hence we cannot test it directly.
    // However, we can test it by checking the console output.
    // For this example, I've left the method untested. You can test it if you want to.
}