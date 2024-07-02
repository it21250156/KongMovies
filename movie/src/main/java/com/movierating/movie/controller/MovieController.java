package com.movierating.movie.controller;

import com.movierating.movie.model.Movie;
import com.movierating.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

//    Add movies
    @PostMapping("/add")
    public String addMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return "New Movie added";
    }

//    Get all movies
    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

//    Get single movie
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Integer id){
        try {
            Movie movie = movieService.getMovie(id);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
    }

//    Update movie
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie movie){
        try {
            Movie existingMovie = movieService.getMovie(id);
            movieService.saveMovie(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
    }

//    Delete movie
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return "Deleted Movie with id " +id;
    }
}
