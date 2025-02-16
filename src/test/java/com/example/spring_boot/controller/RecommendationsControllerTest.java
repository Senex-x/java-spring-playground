package com.example.spring_boot.controller;

import com.example.spring_boot.bean.MoviesRepository;
import com.example.spring_boot.entity.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecommendationsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    MoviesRepository moviesRepository;

    @Test
    void testRecommendations() throws Exception {
        when(moviesRepository.getBestMoviesFirst()).thenReturn(TEST_MOVIES);

        mockMvc.perform(get("/recommendations")).andExpectAll(
                status().isOk(),
                content().string(containsString(TEST_MOVIES.get(0).getName())),
                content().string(containsString(Integer.toString(TEST_MOVIES.get(0).getRating()))),
                content().string(containsString(TEST_MOVIES.get(0).getComment()))
        );
    }

    private static final List<Movie> TEST_MOVIES = List.of(
            new Movie(0L, "Some name 1", 3, "Some comment 1"),
            new Movie(1L, "Some name 2", 2, "Some comment 2"),
            new Movie(2L, "Some name 3", 5, "Some comment 3")
    );
}