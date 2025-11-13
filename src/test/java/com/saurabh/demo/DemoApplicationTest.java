package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.boot.test.context.SpringBootTest;

public class DemoApplicationTest {

    @Test
    public void mainShouldNotThrowException() {
        DemoApplication.main(new String[0]);
        assertTrue(true); // This test will always pass as main() is not designed to return or throw an exception
    }
}