package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MathServiceTests {

    @InjectMocks
    private MathService mathService;

    @Test
    public void testMultiply() {
        int result = mathService.multiply(5, 5);
        assertEquals(25, result);
    }

    @Test
    public void testMultiplyEdgeCase() {
        int result = mathService.multiply(10, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testDivide() {
        double result = mathService.divide(12, 3);
        assertEquals(4.0, result);
    }

    @Test
    public void testDivideNegative() {
        double result = mathService.divide(-12, 3);
        assertEquals(-4.0, result);
    }

    @Test
    public void testDivideZero() {
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(12, 0));
    }

    @Test
    public void testDivideNegativeZero() {
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(12, -0));
    }

    @Test
    public void testGenerateTable() {
        String result = mathService.generateTable(5, 10);
        assertEquals("5 x 1 = 5\n" +
                "5 x 2 = 10\n" +
                "5 x 3 = 15\n" +
                "5 x 4 = 20\n" +
                "5 x 5 = 25\n" +
                "5 x 6 = 30\n" +
                "5 x 7 = 35\n" +
                "5 x 8 = 40\n" +
                "5 x 9 = 45\n" +
                "5 x 10 = 50\n", result);
    }

    @Test
    public void testGenerateTableEdgeCase() {
        String result = mathService.generateTable(5, 0);
        assertEquals("", result);
    }

    @Test
    public void testCountUpTo() {
        String result = mathService.countUpTo(10);
        assertEquals("1 2 3 4 5 6 7 8 9 10", result);
    }

    @Test
    public void testCountUpToEdgeCase() {
        String result = mathService.countUpTo(0);
        assertEquals("", result);
    }

    @Test
    public void testHelloworld() {
        String result = mathService.helloworld();
        assertEquals("hoshiyar", result);
    }

    @Test
    public void testPrintButterfly() {
        // Print to the console for now
        mathService.printButterfly(5);
        // In future we can use an IOUtil for logging
    }

    @Test
    public void testPrintButterflyEdgeCase() {
        // Print to the console for now
        mathService.printButterfly(0);
        // In future we can use an IOUtil for logging
    }
}
```

```java
package com.saurabh.demo.service;

public class IOUtil{

    public static void println(Object str) {
        System.out.println(str);
    }
}