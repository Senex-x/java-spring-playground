package com.example.spring_boot;

import com.example.spring_boot.bean.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
