package com.example.spring_boot.entity;

public class Movie {

    public Movie(Long id, String name, int rating, String comment) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.comment = comment;
    }

    private long id;

    private String name;

    private int rating;

    private String comment;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
