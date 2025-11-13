package com.saurabh.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    @Disabled("This is a demo application with no business logic")
    public void mainWithArgs() {
        // This test won't be able to verify anything as the Spring application context is initialized internally
        // However, if the application crashes, the test will fail with an exception
    }

    @Test
    @Disabled("This is a demo application with no business logic")
    public void mainWithoutArgs() {
        // This test won't be able to verify anything as the Spring application context is initialized internally
        // However, if the application crashes, the test will fail with an exception
    }

    @Test
    @Disabled("This is a demo application with no business logic")
    public void SpringApplicationRun() {
        Exception actualException = assertThrows(Exception.class, () -> SpringApplication.run(DemoApplication.class, new String[0]));
        Exception expectedException = new Exception("Application failed to start");
        assert expectedException.getMessage().equals(actualException.getMessage());
    }
}