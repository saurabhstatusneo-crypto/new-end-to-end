package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DemoApplicationTest {

    @Test
    void contextLoads() {
        // This test ensures that the application context is loaded correctly
    }

    @Test
    public void testMain() {
        // You can't directly test the main method in a Spring Boot application
        // because it's not possible to start the application in a test context.
        // However, you can test other public methods or services in your application.
    }

    // Since there are no other public methods in the DemoApplication class,
    // you can add tests for any services or repositories that you have in your application.
}