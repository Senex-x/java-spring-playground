package com.example.spring_boot.controller;

import com.example.spring_boot.bean.MoviesRepository;
import com.example.spring_boot.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MoviesController {

    @Autowired
    public MoviesController(MoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }

    MoviesRepository moviesRepository;

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", moviesRepository.getMovies());
        return "movies";
    }

    @PostMapping("/movie/add")
    public String addMovie(@ModelAttribute Movie movie, Model model) {
        moviesRepository.addMovie(movie);
        model.addAttribute("movies", moviesRepository.getMovies());
        return "movies";
    }

}
