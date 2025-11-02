package com.integrationninjas.springbootexample.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TestController.class)
class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello_ReturnsExpectedJson() throws Exception {
        mockMvc.perform(get("/")) // sends an HTTP GET request to the endpoint defined in your controller’s @GetMapping.
                .andExpect(status().isOk()) // status 200 - ok
                .andExpect(jsonPath("$.name").value("djini"))
                .andExpect(jsonPath("$.email").value("denislavdanov@gmail.com"));
    }
}