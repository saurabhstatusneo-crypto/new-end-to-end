package com.saurabh.demo.controller.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @Mock
    private MathService mathService;

    @InjectMocks
    private MathController mathController;

    @BeforeEach
    public void setup() {
        // Initialize the controller with mocked service before each test
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 15;
        when(mathService.multiply(a, b)).thenReturn(expected);

        // Act
        int result = mathController.multiply(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testMultiply_zeroDivisionException() {
        // Arrange
        int a = 5;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> mathController.multiply(a, b));
    }

    @Test
    public void testMultiply_negativeNumbers() {
        // Arrange
        int a = -5;
        int b = 3;
        int expected = -15;
        when(mathService.multiply(a, b)).thenReturn(expected);

        // Act
        int result = mathController.multiply(a, b);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 10;
        int b = 2;
        double expected = 5.0;
        when(mathService.divide(a, b)).thenReturn(expected);

        // Act
        double result = mathController.divide(a, b);

        // Assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testDivide_zeroDivisionException() {
        // Arrange
        int a = 10;
        int b = 0;
        assertThrows(ArithmeticException.class, () -> mathController.divide(a, b));
    }

    @Test
    public void testDivide_negativeNumbers() {
        // Arrange
        int a = 10;
        int b = -2;
        double expected = -5.0;
        when(mathService.divide(a, b)).thenReturn(expected);

        // Act
        double result = mathController.divide(a, b);

        // Assert
        assertEquals(expected, result, 0.1);
    }

    @Test
    public void testTable() {
        // Arrange
        int number = 5;
        int upTo = 10;
        String expected = "5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n5 x 6 = 30\n5 x 7 = 35\n5 x 8 = 40\n5 x 9 = 45\n5 x 10 = 50";

        when(mathService.generateTable(number, upTo)).thenReturn(expected);

        // Act
        String result = mathController.table(number, upTo);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testTable_defaultUpTo() {
        // Arrange
        int number = 5;
        String expected = "5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n5 x 6 = 30\n5 x 7 = 35\n5 x 8 = 40\n5 x 9 = 45\n5 x 10 = 50";

        when(mathService.generateTable(number, 10)).thenReturn(expected);

        // Act
        String result = mathController.table(number);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testCount() {
        // Arrange
        int n = 10;
        String expected = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10";

        when(mathService.countUpTo(n)).thenReturn(expected);

        // Act
        String result = mathController.count(n);

        // Assert
        assertEquals(expected, result);
    }
}