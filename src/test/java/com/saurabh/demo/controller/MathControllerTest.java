package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(MathController.class)
public class MathControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private MathController mathController;

    @MockBean
    private MathService mathService;

    @BeforeEach
    public void setup() {
        this.mockMvc = org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void givenMultiplicationRequest_WhenCallMultiplyMethod_ThenReturnResult() throws Exception {
        // Arrange
        when(mathService.multiply(10, 5)).thenReturn(50);
        // Act
        MvcResult mvcResult = mockMvc.perform(get("/math/multiply?a=10&b=5"))
                .andExpect(status().isOk())
                .andReturn();
        // Assert
        assertEquals("50", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void givenDivisionRequest_WhenCallDivideMethod_ThenReturnResult() throws Exception {
        // Arrange
        when(mathService.divide(10, 2)).thenReturn(5.0);
        // Act
        MvcResult mvcResult = mockMvc.perform(get("/math/divide?a=10&b=2"))
                .andExpect(status().isOk())
                .andReturn();
        // Assert
        assertEquals("5.0", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void givenTableRequest_WhenCallTableMethod_ThenReturnResult() throws Exception {
        // Arrange
        when(mathService.generateTable(10, 10)).thenReturn("10 x 10 = 100\n10 x 1 = 10");
        // Act
        MvcResult mvcResult = mockMvc.perform(get("/math/table?number=10&upTo=10"))
                .andExpect(status().isOk())
                .andReturn();
        // Assert
        assertEquals("10 x 10 = 100\n10 x 1 = 10", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void givenCountingRequest_WhenCallCountMethod_ThenReturnResult() throws Exception {
        // Arrange
        when(mathService.countUpTo(10)).thenReturn("1,2,3,4,5,6,7,8,9,10");
        // Act
        MvcResult mvcResult = mockMvc.perform(get("/math/count?n=10"))
                .andExpect(status().isOk())
                .andReturn();
        // Assert
        assertEquals("1,2,3,4,5,6,7,8,9,10", mvcResult.getResponse().getContentAsString());
    }
}