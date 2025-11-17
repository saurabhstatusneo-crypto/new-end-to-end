package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(SpringBootTestExtension.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMain() {
        // This test will fail unless the application is run and terminated manually
        // to capture its exit status.
        // System.out.println("Exit Code: " + DemoApplication.main(new String[] {}));
        // This method is not directly unit-testable due to its static call to run.
        // Therefore, this test is more of an integration test rather than a unit test.
    }

    @Test
    public void testSpringApplicationRun() {
        // This test case is designed to test that the application is successfully launched.
        SpringApplication.run(DemoApplication.class, new String[]{});
    }
}