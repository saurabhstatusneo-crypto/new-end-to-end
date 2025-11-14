package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMain() {
        DemoApplication main = new DemoApplication();
        String[] args = {};
        Exception exception = assertThrows(Exception.class, () -> main.main(args));
        assertEquals("The main method has no source code in DemoApplication", exception.getMessage());
    }
}