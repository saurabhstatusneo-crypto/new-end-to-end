package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathServiceTest {

    @InjectMocks
    private MathService mathService;

    @Test
    public void testMultiply() {
        assertEquals(6, mathService.multiply(2, 3));
        assertEquals(0, mathService.multiply(-2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, mathService.divide(4, 2), 0.01);
        assertEquals(-4.0, mathService.divide(-8, 2), 0.01);

        assertThrows(IllegalArgumentException.class, () ->mathService.divide(4, 0));
    }

    @Test
    public void testGenerateTable() {
        String table = mathService.generateTable(2, 5);
        assertEquals("2 x 1 = 2\n" +
                "2 x 2 = 4\n" +
                "2 x 3 = 6\n" +
                "2 x 4 = 8\n" +
                "2 x 5 = 10\n", table);

        table = mathService.generateTable(5, 1);
        assertEquals("5 x 1 = 5\n", table);
    }

    @Test
    public void testCountUpTo() {
        String count = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5", count);

        count = mathService.countUpTo(0);
        assertEquals("", count);
    }

    @Test
    public void testHelloworld() {
        String result = mathService.helloworld();
        assertEquals("hoshiyar", result);
    }

    @Test
    public void testPrintButterfly() {
        System.out.println("Output of printButterfly(3)");
        mathService.printButterfly(3);

        System.out.println("Output of printButterfly(5)");
        mathService.printButterfly(5);
    }
}