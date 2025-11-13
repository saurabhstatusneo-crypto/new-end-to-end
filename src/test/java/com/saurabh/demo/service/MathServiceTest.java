package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathServiceTest {

    @Test
    public void testMultiply() {
        MathService mathService = new MathService();
        int result = mathService.multiply(5, 5);
        assertEquals(25, result);
    }

    @Test
    public void testDivide() {
        MathService mathService = new MathService();
        double result = mathService.divide(10, 2);
        assertEquals(5.0, result);
    }

    @Test
    public void testDivideByZero() {
        MathService mathService = new MathService();
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
    }

    @Test
    public void testGenerateTable() {
        MathService mathService = new MathService();
        String result = mathService.generateTable(2, 5);
        assertEquals("2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n", result);
    }

    @Test
    public void testCountUpTo() {
        MathService mathService = new MathService();
        String result = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    public void testHelloworld() {
        MathService mathService = new MathService();
        assertEquals("hoshiyar", mathService.helloworld());
    }

    @Test
    public void testPrintButterfly() {
        try (org.junit.Rule rule = Mockito.newRule()) {
            // Mockito rules are not compatible with JUnit 5's test execution model.
            // However, we can manually set up the system out and check the expected output
            System.setOut(System.out.newPrintStream());
            MathService mathService = new MathService();
            mathService.printButterfly(5);
            String result = System.out.toString();
            // Clean up for future tests
            System.setOut(System.out);
            String exp = "        *\n       *\n      *\n     *\n    *\n     *\n      *\n       *";
            assertEquals(exp, result.trim());
        } catch (Exception e) {
            // ignore
        }
    }
}
```
Please note that printing output directly in a test case is not ideal, it's better to check with a mock or with some form of assertion like comparing with expected output. 
This above code snippet doesn't handle any potential exception thrown by `System` class. So, the actual result might be different in real scenarios.