package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DemoApplicationTest {

    @Test
    void testRunWithNullArguments() {
        assertThrows(IllegalArgumentException.class, () -> SpringApplication.run(DemoApplication.class, null));
    }

    @Test
    void testRunWithEmptyArguments() {
        SpringApplication.run(DemoApplication.class, new String[0]);
    }

    @Test
    void testRunWithSingleArgument() {
        SpringApplication.run(DemoApplication.class, new String[]{"test"});
    }

    @Test
    void testRunWithMultipleArguments() {
        SpringApplication.run(DemoApplication.class, new String[]{"test1", "test2", "test3"});
    }

    @Test
    void testRunWithEmptyArgumentsExpectRun() {
        try {
            SpringApplication.run(DemoApplication.class, new String[0]);
            assertEquals(true, true);
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
            assert false;
        }
    }

    @Test
    void testRunWithNullArgumentsExpectThrowException() {
        try {
            SpringApplication.run(DemoApplication.class, null);
            assert false;
        } catch (Exception e) {
            assertEquals(true, e instanceof IllegalArgumentException);
        }
    }
}