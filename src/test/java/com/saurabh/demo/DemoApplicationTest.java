package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class DemoApplicationTest {

    @Test
    public void testMainMethod() {
        String[] args = {};
        DemoApplication.main(args);
        // There's no way to verify the main method in JUnit or any unit test framework because it starts a Spring app.
        // Normally, you'd create an integration test to verify the application's behavior.
    }

    // Since there are no public methods in DemoApplication class, there's no need to write any test case.
    // If public methods are added to the DemoApplication class, you should write test cases for those methods.
}