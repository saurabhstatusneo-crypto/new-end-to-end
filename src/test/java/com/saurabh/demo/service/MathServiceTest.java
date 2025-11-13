package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.util.MatcherAssertionError.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

public class MathServiceTest {

    private final MathService mathService = new MathService();
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream newOut = new PrintStream(output);

    @BeforeAll
    public void setUp() {
        System.setOut(newOut);
    }

    @AfterAll
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testMultiply_PositiveNumbers_ReturnsProduct() {
        // Given
        int num1 = 5;
        int num2 = 3;

        // When
        int result = mathService.multiply(num1, num2);

        // Then
        assertEquals(num1 * num2, result);
    }

    @Test
    public void testMultiply_Zero_ReturnsZero() {
        // Given
        int num1 = 0;
        int num2 = 3;

        // When
        int result = mathService.multiply(num1, num2);

        // Then
        assertEquals(num1 * num2, result);
    }

    @Test
    public void testDivide_PositveNumbers_ReturnsQuotient() {
        // Given
        int dividend = 10;
        int divisor = 2;

        // When
        double result = mathService.divide(dividend, divisor);

        // Then
        assertEquals((double) dividend / divisor, result);
    }

    @Test
    public void testDivide_ByZero_ThrowsIllegalArgumentException() {
        // Given
        int dividend = 10;
        int divisor = 0;

        // When and Then
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(dividend, divisor));
    }

    @Test
    public void testGenerateTable_TableIsValid() {
        // Given
        int number = 5;
        int upTo = 5;

        // When
        String table = mathService.generateTable(number, upTo);

        // Then
        String expected = "5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n";
        assertEquals(expected, table);
    }

    @Test
    public void testNameCountUpTo_CountIsValid() {
        // Given
        int upTo = 5;

        // When
        String count = mathService.countUpTo(upTo);

        // Then
        String expected = "1 2 3 4 5";
        assertEquals(expected, count);
    }

    @Test
    public void testhelloworld_ReturnsGivenMessage() {
        // When
        String result = mathService.helloworld();

        // Then
        assertEquals("hoshiyar", result);
    }

    @Test
    public void testPrintButterfly_PrintsButterflyShape() {
        // Given
        int n = 5;

        // When and Then
        mathService.printButterfly(n);
        String expected = " ***** \n **** \n ***  \n **   \n *    \n **** \n ***  \n **   \n *    \n ***** \n";
        assertEquals(expected, new String(output.toByteArray()));
    }
}