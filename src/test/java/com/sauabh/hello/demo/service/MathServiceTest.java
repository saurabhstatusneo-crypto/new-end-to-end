import org.junit.jupiter.api.Assertions;

package com.sauabh.hello.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {

    @Test
    void testConstructor() {
        MathService mathService = new MathService();
        assertNotNull(mathService);
    }

    @Test
    void testAdd() {
        // Assuming MathService has an add method
        MathService mathService = new MathService();
        int result = mathService.add(2, 2);
        assertEquals(4, result);
    }

    @Test
    void testSubtract() {
        // Assuming MathService has a subtract method
        MathService mathService = new MathService();
        int result = mathService.subtract(4, 2);
        assertEquals(2, result);
    }

    @Test
    void testMultiply() {
        // Assuming MathService has a multiply method
        MathService mathService = new MathService();
        int result = mathService.multiply(4, 2);
        assertEquals(8, result);
    }

    @Test
    void testDivide() {
        // Assuming MathService has a divide method
        MathService mathService = new MathService();
        int result = mathService.divide(8, 2);
        assertEquals(4, result);
    }

    @Test
    void testSquareRoot() {
        // Assuming MathService has a squareRoot method
        MathService mathService = new MathService();
        double result = mathService.squareRoot(16);
        assertEquals(4, result, 0.01);
    }

    @Test
    void testRound() {
        // Assuming MathService has a round method
        MathService mathService = new MathService();
        double result = mathService.round(4.56);
        assertEquals(4.6, result, 0.01);
    }

    @Test
    void testCeil() {
        // Assuming MathService has a ceil method
        MathService mathService = new MathService();
        double result = mathService.ceil(4.56);
        assertEquals(5.0, result, 0.01);
    }

    @Test
    void testFloor() {
        // Assuming MathService has a floor method
        MathService mathService = new MathService();
        double result = mathService.floor(4.56);
        assertEquals(4.0, result, 0.01);
    }

    @Test
    void testPow() {
        // Assuming MathService has a pow method
        MathService mathService = new MathService();
        double result = mathService.pow(2, 3);
        assertEquals(8, result, 0.01);
    }
}