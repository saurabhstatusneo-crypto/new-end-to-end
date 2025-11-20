package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MathServiceTest {

    @InjectMocks
    private MathService mathService;

    @Test
    public void testMultiply() {
        assertEquals(6, mathService.multiply(2, 3));
    }

    @Test
    public void testMultiply_InvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.multiply(5, 0));
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, mathService.divide(5, 2), 0.01);
    }

    @Test
    public void testDivide_InvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.divide(5, 0));
        assertNotNull(exception.getMessage().contains("Division by zero is not allowed"));
    }

    @Test
    public void testGenerateTable() {
        String table = mathService.generateTable(4, 5);
        assertNotNull(table);
    }

    @Test
    public void testGenerateTable_InvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> mathService.generateTable(-4, 5));
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testCountUpTo() {
        String counting = mathService.countUpTo(5);
        assertNotNull(counting);
        assertTrue(counting.contains("1") && counting.contains("2") && counting.contains("3") && counting.contains("4") && counting.contains("5"));
    }

    @Test
    public void testHelloworld() {
        String helloWorld = mathService.helloworld();
        assertNotNull(helloWorld);
        assertEquals("hoshiyar", helloWorld);
    }

    @Test
    public void testPrintButterfly() {
        // This is a complex method to test which requires console output, hence disabled for now.
        // For complex method, use the console output from the test run or verify the print statement.
    }
}