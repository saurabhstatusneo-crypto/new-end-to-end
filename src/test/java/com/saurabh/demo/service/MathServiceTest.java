package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MathServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(outContent));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testMultiply() {
        MathService mathService = new MathService();
        int result = mathService.multiply(5, 6);
        assertEquals(30, result);
    }

    @Test
    void testMultiplyWithZero() {
        MathService mathService = new MathService();
        assertThrows(IllegalArgumentException.class, () -> mathService.multiply(5, 0));
    }

    @Test
    void testDivide() {
        MathService mathService = new MathService();
        double result = mathService.divide(10, 2);
        assertEquals(5.0, result);
    }

    @Test
    void testDivideByZero() {
        MathService mathService = new MathService();
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
    }

    @Test
    void testGenerateTable() {
        MathService mathService = new MathService();
        String result = mathService.generateTable(5, 5);
        assertEquals("5 x 1 = 5\n" +
                "5 x 2 = 10\n" +
                "5 x 3 = 15\n" +
                "5 x 4 = 20\n" +
                "5 x 5 = 25\n", result);
    }

    @Disabled
    @Test
    void testCountUpTo() {
        MathService mathService = new MathService();
        String result = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5 ", result);
    }

    @Test
    void testHelloWorld() {
        final boolean systemOutContentIsCaptorEnabled = MathService.class.getResource("HelloWorld.class") != null;
        MathService mathService = new MathService();
        String result = mathService.helloworld();
        assertEquals("hoshiyar", result);
    }

    @Test
    void testPrintButterfly() {
        MathService mathService = new MathService();
        mathService.printButterfly(5);
        StringBuilder expected = new StringBuilder();
        expected.append("        *\n" +
                "       * *\n" +
                "      * * *\n" +
                "     * * * *\n" +
                "    * * * * *\n" +
                "     * * * *\n" +
                "      * * *\n" +
                "       * *\n" +
                "        *\n");
        assertEquals(expected.toString(), outContent.toString().trim());
    }
}