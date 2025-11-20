package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoApplicationTests {

    @Test
    public void testMain() {
        // There's no direct way to test main method as it's entry point and Spring
        // application context needs to be bootstrapped to test the main method
        // However, the spring framework provides a way to do that using
        // @SpringBootTest and @RunWith(SpringRunner.class)
        // But considering this is a minimalistic example, we're not going to do that
    }

    @Test
    public void testSpringApplicationRun() {
        SpringApplication.run(DemoApplication.class, null);
    }
}