package com.saurabh.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.saurabh.demo.DemoApplication;

public class DemoApplicationTest {

    @Test
    void contextLoads() {
        // No assertions needed as no explicit context loading is required
    }

    @Test
    void mainMethodRunsApplication() {
        DemoApplication.main(new String[]{});
    }
}