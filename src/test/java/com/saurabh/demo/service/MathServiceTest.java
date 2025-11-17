package com.saurabh.demo.service;

import com.saurabh.demo.service.MathService;
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
        int result = mathService.multiply(5, 5);
        assertEquals(25, result);
    }

    @Test
    public void testMultiply_InvalidArguments() {
        int result = mathService.multiply(10, -5);
        assertEquals(-50, result);
    }

    @Test
    public void testDivide() {
        double result = mathService.divide(10, 2);
        assertEquals(5.0, result, 0.01);
    }

    @Test
    public void testDivide_DivisionByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    public void testGenerateTable() {
        String table = mathService.generateTable(5, 5);
        assertEquals("5 x 1 = 5\n" +
                "5 x 2 = 10\n" +
                "5 x 3 = 15\n" +
                "5 x 4 = 20\n" +
                "5 x 5 = 25\n", table);
    }

    @Test
    public void testCountUpTo() {
        String count = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5", count);
    }

    @Test
    public void testHelloworld() {
        String helloworld = mathService.helloworld();
        assertEquals("hoshiyar", helloworld);
    }

    @Test
    public void testPrintButterfly() {
        // printButterfly method prints output to the console, so it's difficult to test directly.
        // However, we can test if the output is correct by comparing with an expected output.
        mathService.printButterfly(5);
        // Here, you need to write your expected output in a string and compare with it.
    }
}