package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MathServiceTest {

    @Autowired
    private MathService mathService;

    @Test
    public void testMultiply() {
        assertEquals(2, mathService.multiply(1, 2));
        assertEquals(-6, mathService.multiply(-3, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(3.0, mathService.divide(6, 2));
        assertEquals(-0.75, mathService.divide(-3, 4));
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(6, 0));
    }

    @Test
    public void testGenerateTable() {
        assertEquals("1 x 1 = 1\n2 x 1 = 2\n3 x 1 = 3\n4 x 1 = 4\n5 x 1 = 5\n", mathService.generateTable(1, 5));
    }

    @Test
    public void testCountUpTo() {
        assertEquals("1 2 3 4 5", mathService.countUpTo(5));
    }

    @Test
    public void testHelloworld() {
        assertEquals("hoshiyar", mathService.helloworld());
    }

    @Test
    public void testPrintButterfly() {
        System.out.println("Running testPrintButterfly");
    }
}