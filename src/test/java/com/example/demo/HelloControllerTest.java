package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest {

    private HelloController controller;

    @BeforeEach
    void setUp() {
        controller = new HelloController();
    }

    @Test
    void hello_ShouldReturnDefaultValue_WhenEnvNotSet() {
        ReflectionTestUtils.setField(controller, "environment", "world");

        String result = controller.hello();

        assertEquals("hello world", result);
    }

    @Test
    void hello_ShouldReturnCustomValue_WhenEnvIsSet() {
        ReflectionTestUtils.setField(controller, "environment", "staging");

        String result = controller.hello();

        assertEquals("hello staging", result);
    }
}
