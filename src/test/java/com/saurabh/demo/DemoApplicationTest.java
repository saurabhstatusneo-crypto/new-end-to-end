package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoApplicationTests {

    @Test
    void testMain() {
        DemoApplication.main(new String[]{});
        assertDoesNotThrow(() -> {
            DemoApplication.main(new String[]{});
        });
    }

    @Test
    void testSpringApplication() {
        assertDoesNotThrow(() -> SpringApplication.run(DemoApplication.class, new String[]{}));
    }

}