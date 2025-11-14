package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMain() {
        // Since the main method is not testable directly, we can't assert its behavior.
        // It will throw an exception if anything goes wrong.
        try {
            DemoApplication.main(new String[0]);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}