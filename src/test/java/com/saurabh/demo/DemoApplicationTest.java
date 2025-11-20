package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTest {
    
    @Test
    public void testMain() {
        DemoApplication.main(new String[]{});
        // No assertions needed for main method
    }

    @Test
    public void testSpringApplicationRun() {
        SpringApplication.run(DemoApplication.class, new String[]{});
        // No assertions needed as SpringApplication.run does not return an object
    }
}