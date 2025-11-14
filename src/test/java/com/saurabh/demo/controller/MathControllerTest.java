package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MathControllerTest {

    @InjectMocks
    private MathController mathController;

    @Mock
    private MathService mathService;

    @Test
    public void testMultiply() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 15;
        when(mathService.multiply(a, b)).thenReturn(expected);

        // Act
        int actual = mathController.multiply(a, b);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 15;
        int b = 3;
        double expected = 5.0;
        when(mathService.divide(a, b)).thenReturn(expected);

        // Act
        double actual = mathController.divide(a, b);

        // Assert
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void testTable() {
        // Arrange
        int number = 5;
        int upTo = 10;
        String expected = "Table for 5 up to 10: \n" +
                "5*1=5\n" +
                "5*2=10\n" +
                "5*3=15\n" +
                "5*4=20\n" +
                "5*5=25\n" +
                "5*6=30\n" +
                "5*7=35\n" +
                "5*8=40\n" +
                "5*9=45\n" +
                "5*10=50\n";
        when(mathService.generateTable(number, upTo)).thenReturn(expected);

        // Act
        String actual = mathController.table(number, upTo);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testCount() {
        // Arrange
        int n = 5;
        String expected = "Count up to 5: 0\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n";
        when(mathService.countUpTo(n)).thenReturn(expected);

        // Act
        String actual = mathController.count(n);

        // Assert
        assertEquals(expected, actual);
    }
}