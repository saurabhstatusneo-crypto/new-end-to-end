import org.junit.jupiter.api.Assertions;

package com.sauabh.hello.demo.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathControllerTest {

    @Test
    public void testMathControllerConstructor() {
        MathController mathController = new MathController();
        assertNotNull(mathController);
    }

    @Test
    public void testAddNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.addNumbers(0, 0));
    }

    @Test
    public void testAddNumbersWithNegativeNumbers() {
        MathController mathController = new MathController();
        assertEquals("-1", mathController.addNumbers(-1, 0));
    }

    @Test
    public void testAddNumbersWithDecimalNumbers() {
        MathController mathController = new MathController();
        assertEquals("0.5", mathController.addNumbers(0.5, 0));
    }

    @Test
    public void testSubtractNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.subtractNumbers(0, 0));
    }

    @Test
    public void testSubtractNumbersWithNegativeNumbers() {
        MathController mathController = new MathController();
        assertEquals("1", mathController.subtractNumbers(0, -1));
    }

    @Test
    public void testSubtractNumbersWithDecimalNumbers() {
        MathController mathController = new MathController();
        assertEquals("0.5", mathController.subtractNumbers(0.5, 0));
    }

    @Test
    public void testMultiplyNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.multiplyNumbers(0, 0));
    }

    @Test
    public void testMultiplyNumbersWithNegativeNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.multiplyNumbers(-1, 0));
    }

    @Test
    public void testMultiplyNumbersWithDecimalNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.multiplyNumbers(0.5, 0));
    }

    @Test
    public void testDivideNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.divideNumbers(0, 0));
    }

    @Test
    public void testDivideNumbersWithNegativeNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.divideNumbers(-1, 0));
    }

    @Test
    public void testDivideNumbersWithDecimalNumbers() {
        MathController mathController = new MathController();
        assertEquals("0", mathController.divideNumbers(0.5, 0));
    }

    @Test
    public void testDivideByZero() {
        MathController mathController = new MathController();
        try {
            mathController.divideNumbers(0, 0);
            fail("Expected ArithmeticException");
        } catch (ArithmeticException e) {
            // Expected
        }
    }
}