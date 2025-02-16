package com.example.spring_boot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

    @Autowired
    MockMvc mockMvc;

    TruthProvider provider = Mockito.mock();

    @Test
    void test() throws Exception {
        when(provider.provide()).thenReturn(true);

        mockMvc.perform(get("/message"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<!DOCTYPE HTML>")));
    }
}