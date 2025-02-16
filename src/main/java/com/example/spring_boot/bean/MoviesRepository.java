package com.example.spring_boot.bean;

import com.example.spring_boot.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Component
public class MoviesRepository {

    private long idCounter = 0;

    private final List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie(idCounter++, "Some name 1", new Random().nextInt(1, 6), null));
        movies.add(new Movie(idCounter++, "Some name 2", new Random().nextInt(1, 6), null));
        movies.add(new Movie(idCounter++, "Some name 3", new Random().nextInt(1, 6), null));
    }

    public void addMovie(String name, int rating, String comment) {
        movies.add(new Movie(idCounter++, name, rating, comment));
    }

    public void updateRating(long movieId, int rating) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                movie.setRating(rating);
            }
        }
    }

    public void updateComment(long movieId, String comment) {
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                movie.setComment(comment);
            }
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> getBestMoviesFirst() {
        return movies.stream().sorted(Comparator.comparingInt(Movie::getRating).reversed()).toList();
    }

    public List<Movie> getOnlyBestMovies() {
        return movies.stream().filter((movie -> movie.getRating() == 5)).toList();
    }
}
