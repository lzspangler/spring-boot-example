package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HelloControllerIntegrationTest {

    @Nested
    @SpringBootTest
    @AutoConfigureMockMvc
    @DisplayName("Default Configuration Tests")
    class DefaultConfigTests {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void shouldReturnDefaultMessage() throws Exception {
            mockMvc.perform(get("/hello"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("hello world"));
        }
    }

    @Nested
    @SpringBootTest(properties = "ENV=qa")
    @AutoConfigureMockMvc
    @DisplayName("Custom ENV Configuration Tests")
    class CustomEnvConfigTests {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void shouldReturnOverriddenEnvMessage() throws Exception {
            mockMvc.perform(get("/hello"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("hello qa"));
        }
    }
}
