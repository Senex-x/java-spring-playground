package com.example.spring_boot.controller;

import com.example.spring_boot.bean.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recommendations")
public class RecommendationsController {

    @Autowired
    public RecommendationsController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    MoviesRepository moviesRepository;

    @GetMapping
    String getRecommendations(Model model) {
        model.addAttribute("movies", moviesRepository.getBestMoviesFirst());
        return "recommendations";
    }

    @GetMapping("/best")
    String getBestRecommendations(Model model) {
        model.addAttribute("movies", moviesRepository.getOnlyBestMovies());
        return "recommendations";
    }
}
