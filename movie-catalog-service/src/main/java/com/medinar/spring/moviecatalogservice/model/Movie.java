package com.medinar.spring.moviecatalogservice.model;

/**
 *
 * @author rommelmedina
 */
public class Movie {

    private String movieId;
    private String name;
    private String description;
    private String overview;

    public Movie() {
    }

    public Movie(String movieId, String name, String description, String overview) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.overview = overview;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

}