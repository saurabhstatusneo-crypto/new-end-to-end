package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.io.ConsoleOutputCapture;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.extension.MethodStats;

@SpringBootTest
public class MathServiceTest {

    @InjectMocks
    private MathService mathService;

    @Mock
    private MathService mockedMathService;

    @Autowired
    private PrintStream printStream;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testMultiply() {
        int a = 5;
        int b = 10;
        assertEquals(multiply(a, b), mathService.multiply(a, b));
    }

    @Test
    public void testMultiply_NegativeNumbers() {
        int a = -5;
        int b = 10;
        assertEquals(multiply(a, b), mathService.multiply(a, b));
    }

    @Test
    public void testMultiply_BigNumbers() {
        int a = 555555;
        int b = 222222;
        assertEquals(multiply(a, b), mathService.multiply(a, b));
    }

    @Test
    public void testDivide() {
        int a = 20;
        int b = 5;
        assertEquals(divide(a, b), mathService.divide(a, b), 0.0);
    }

    @Test
    public void testDivide_DivisionByZero() {
        int a = 20;
        int b = 0;
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(a, b));
    }

    @Test
    public void testDivide_DecimalResult() {
        int a = 10;
        int b = 3;
        assertEquals(divide(a, b), mathService.divide(a, b), 0.0);
    }

    @Test
    public void testGenerateTable() {
        int number = 10;
        int upTo = 5;
        assertDoesNotThrow(() -> mathService.generateTable(number, upTo));
    }

    @Test
    public void testCountUpTo() {
        int n = 10;
        assertEquals(countUpTo(n), mathService.countUpTo(n));
    }

    @Test
    public void testPrintButterfly() {
        int n = 5;
        assertDoesNotThrow(() -> mathService.printButterfly(n));
    }

    @Test
    public void testHelloWorld() {
        String expected = "hoshiyar\nh\no\ns\ni\ny\na\nr";
        String result = helloworld();
        assertEquals(expected, result);
    }

}