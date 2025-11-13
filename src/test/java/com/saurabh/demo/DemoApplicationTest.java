package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMainMethod() {
        DemoApplication.main(new String[]{});
        assertDoesNotThrow(() -> Main.run());
    }

    @Test
    public void testRunMethod() {
        assertDoesNotThrow(() -> SpringApplication.run(DemoApplication.class, new String[]{}));
    }
}