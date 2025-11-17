package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void testMainMethod() {
        // The main method does not return, hence we cannot use asserts here
        // Instead we can use a test suite or a testing framework with a "processExit" functionality, but
        // this is generally not recommended. For our example we assume that everything is fine if the application starts.
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        int returnCode = springApplication.run(args -> {});
        assertEquals(0, returnCode);
    }

    // For the sake of example, I'm assuming a static array of "args" for the test method. You should create these variables as instance variables or
    // make them accessible through another way (like @Autowired) when you need to pass arguments for the 'args' parameter.
    private static final String[] args = new String[0];

}