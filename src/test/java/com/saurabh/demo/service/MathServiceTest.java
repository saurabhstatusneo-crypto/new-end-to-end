package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringJUnitConfig(MathServiceTestConfig.class)
public class MathServiceTest {

    @Autowired
    private MathService mathService;

    @Test
    public void testMultiply() {
        assertEquals(6, mathService.multiply(2, 3));
        assertEquals(0, mathService.multiply(-2, 3));
        assertEquals(-24, mathService.multiply(-3, 8));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, mathService.divide(4, 2), 0.01);
        assertEquals(-2.0, mathService.divide(-4, 2), 0.01);
        assertEquals(0.5, mathService.divide(1, 2), 0.01);

        assertThrows(IllegalArgumentException.class, () -> mathService.divide(4, 0));
    }

    @Test
    public void testGenerateTable() {
        assertEquals("1 x 1 = 1\n" +
                "1 x 2 = 2\n" +
                "1 x 3 = 3\n" +
                "1 x 4 = 4\n" +
                "1 x 5 = 5\n" +
                "1 x 6 = 6\n" +
                "1 x 7 = 7\n" +
                "1 x 8 = 8\n" +
                "1 x 9 = 9\n" +
                "1 x 10 = 10\n", mathService.generateTable(1, 10));
    }

    @Test
    public void testCountUpTo() {
        assertEquals("1 2 3 4 5", mathService.countUpTo(5));
        assertEquals("", mathService.countUpTo(0));
        assertEquals("1", mathService.countUpTo(1));
    }

    @Test
    public void testHelloworld() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mathService.helloworld();
        System.out.println();
        String expectedOutput = "hey world how are you\nh\no\ns\nh\ni\ny\na\nr\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testPrintButterfly() {
        // Since this method prints to the console, we need to redirect the output to capture the result
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        mathService.printButterfly(3);
        System.out.println();
        String expectedOutput =
                "*\n *\n*\n *\n*\n *\n*\n *\n*\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }
}

@Configuration
class MathServiceTestConfig {

    @Bean
    MathService mathService() {
        return new MathService();
    }
}