package com.saurabh.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void testMultiplyInvalid() {
        int result = mathService.multiply(5, 0);
        assertThrows(ArithmeticException.class, () -> mathService.multiply(5, 0));
    }

    @Test
    public void testDivide() {
        double result = mathService.divide(10, 2);
        assertEquals(5.0, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> mathService.divide(10, 0));
    }

    @Test
    public void testGenerateTable() {
        String result = mathService.generateTable(5, 5);
        assertEquals("5 x 1 = 5\n5 x 2 = 10\n5 x 3 = 15\n5 x 4 = 20\n5 x 5 = 25\n", result);
    }

    @Test
    public void testCountUpTo() {
        String result = mathService.countUpTo(5);
        assertEquals("1 2 3 4 5", result);
    }

    @Test
    public void testHelloworld() {
        String result = mathService.helloworld();
        assertEquals("hoshiyar", result);
    }

    @Test
    public void testPrintButterfly() {
        MathService mathServiceTemp = new MathService();
        mathServiceTemp.printButterfly(5);
    }

    @org.junit.runner.RunWith(org.junit.runners.JUnit4.class)
    public static class SystemOutCapture extends DelegatingTestExecutionListener {

        @Override
        public void beforeTestClass(TestContext testContext) throws Exception {
            super.beforeTestClass(testContext);
            MathService mathServiceTemp = new MathService();
            mathServiceTemp.printButterfly(5);
        }
    }

}