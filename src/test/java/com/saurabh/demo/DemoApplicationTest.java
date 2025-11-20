package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMainMethodRunsCorrectly() {
        DemoApplication.main(new String[]{});
        assertTrue(true, "Demo application successfully ran");
    }
}