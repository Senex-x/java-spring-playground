package com.example.spring_boot.bean;

import com.example.spring_boot.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MoviesRepository {

    private long idCounter = 0;

    private final List<Movie> movies = List.of(
            new Movie(idCounter++, "Some name 1", new Random().nextInt(1, 6), null),
            new Movie(idCounter++, "Some name 2", new Random().nextInt(1, 6), null),
            new Movie(idCounter++, "Some name 3", new Random().nextInt(1, 6), null)
    );

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
