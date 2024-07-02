package com.movierating.movie.service;

import com.movierating.movie.model.Movie;

import java.util.List;

public interface MovieService {
    public Movie saveMovie(Movie movie);
    public List<Movie> getAllMovies();
    public Movie getMovie(int id);
    public void deleteMovie(int id);
}
