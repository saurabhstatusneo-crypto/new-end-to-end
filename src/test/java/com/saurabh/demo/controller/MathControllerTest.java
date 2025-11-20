package com.saurabh.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MathController.class)
@AutoConfigureMockMvc
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathService mathService;

    @Test
    void testMultiply() throws Exception {
        // Arrange
        int a = 5;
        int b = 3;
        Mockito.when(mathService.multiply(a, b)).thenReturn(a * b);

        // Act
        String response = mockMvc.perform(get("/math/multiply"))
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertEquals(String.valueOf(a * b), response);
    }

    @Test
    void testMultiply_InvalidInput() {
        // Arrange
        int a = 0;
        int b = 0;
        // Mockito does not support @RequestParam so we will test service method directly
        assertThrows(ArithmeticException.class, () -> mathService.multiply(a, b));
    }

    @Test
    void testDivide() throws Exception {
        // Arrange
        int a = 10;
        int b = 2;
        Mockito.when(mathService.divide(a, b)).thenReturn((double) a / b);

        // Act
        String response = mockMvc.perform(get("/math/divide?a=10&b=2"))
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertEquals(String.valueOf((double) a / b), response);
    }

    @Test
    void testDivide_InvalidInput() {
        // Arrange
        int a = 10;
        int b = 0;
        // Mockito does not support @RequestParam so we will test service method directly
        assertThrows(ArithmeticException.class, () -> mathService.divide(a, b));
    }

    @Test
    void testTable() throws Exception {
        // Arrange
        int number = 5;
        int upTo = 10;
        Mockito.when(mathService.generateTable(number, upTo)).thenReturn(String.valueOf(number) + " x tabla");

        // Act
        String response = mockMvc.perform(get("/math/table?number=5&upTo=10"))
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertEquals("5 x tabla", response);
    }

    @Test
    void testCount() throws Exception {
        // Act
        String response = mockMvc.perform(get("/math/count"))
                .andReturn().getResponse().getContentAsString();

        // Assert
        assertEquals(response, "");
    }

    @Test
    void testCount_InvalidInput() throws Exception {
        // Act
        String response = mockMvc.perform(get("/math/count?n=-1"))
                .andReturn().response().getContentAsString();

        // Assert
        assertEquals(response, "");
    }
}