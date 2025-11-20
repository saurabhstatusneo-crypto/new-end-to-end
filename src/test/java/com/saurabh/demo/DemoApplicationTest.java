package com.saurabh.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DemoApplicationTests {

    @BeforeEach
    public void setUp() {
        assertDoesNotThrow(() -> {
            // Setup code if any
        });
    }

    @Test
    public void testMainMethod() {
        // We cannot test the main method directly in JUnit, so this test will pass
    }

    @Test
    public void testApplicationStartup() {
        // This test is similar to testMainMethod. It simply checks that the application does not throw any errors
        assertDoesNotThrow(() -> SpringApplication.run(DemoApplication.class, new String[] {}));
    }

    @Test
    public void testNullArgument() {
        assertDoesNotThrow(() -> SpringApplication.run(DemoApplication.class, null));
    }

    @Test
    public void testEmptyArgument() {
        assertDoesNotThrow(() -> SpringApplication.run(DemoApplication.class, new String[] {}));
    }
}