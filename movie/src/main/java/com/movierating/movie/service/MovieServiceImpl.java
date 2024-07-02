package com.movierating.movie.service;

import com.movierating.movie.model.Movie;
import com.movierating.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public void deleteMovie(int id) {
        movieRepository.deleteById(id);
    }
}
