package com.saurabh.demo.controller;

import com.saurabh.demo.service.MathService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.junit.jupiter.api.Assertions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MathControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MathService mathService;

    @InjectMocks
    private MathController mathController;

    @Autowired
    public void setMathController(MathController mathController) {
        this.mathController = mathController;
    }

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(mathController).build();
    }

    @Test
    public void testMultiply() throws Exception {
        // Arrange
        when(mathService.multiply(anyInt(), anyInt())).thenReturn(10);

        // Act
        MvcResult result = mockMvc.perform(get("/math/multiply")
                .param("a", "2")
                .param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"))
                .andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testDivide() throws Exception {
        // Arrange
        when(mathService.divide(anyInt(), anyInt())).thenReturn(2.5);

        // Act
        MvcResult result = mockMvc.perform(get("/math/divide")
                .param("a", "10")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.5"))
                .andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testTable() throws Exception {
        // Arrange
        when(mathService.generateTable(anyInt(), anyInt())).thenReturn("Table generated");

        // Act
        MvcResult result = mockMvc.perform(get("/math/table")
                .param("number", "2")
                .param("upTo", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("Table generated"))
                .andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    public void testCount() throws Exception {
        // Arrange
        when(mathService.countUpTo(anyInt())).thenReturn("Count generated");

        // Act
        MvcResult result = mockMvc.perform(get("/math/count")
                .param("n", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("Count generated"))
                .andReturn();

        // Assert
        assertEquals(200, result.getResponse().getStatus());
    }

}
```

Please note that `MvcResult` is a result object that provides a result of the request, and `andExpect` method is a way to specify expected results or assertions about the result.

To use MockMvc for testing we also need to add MockMvc and Spring Boot Test dependency in our project.

Also note that in the provided test, the MathService behavior is being stubbed using Mockito for better unit test coverage.

The test class should be placed in the same package as the `MathController` class.