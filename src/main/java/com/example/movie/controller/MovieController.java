/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.movie.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieJpaService;

@RestController
public class MovieController {

    @Autowired
    private MovieJpaService service;

    @GetMapping("/movies")
    public ArrayList<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieById(@PathVariable("movieId") int movieId) {
        return service.getMovieById(movieId);
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }

    @PutMapping("/movies/{movieId}")
    public Movie updateMovie(@PathVariable("movieId") int movieId, @RequestBody Movie movie) {
        return service.updateMovie(movieId, movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public void deleteMovie(@PathVariable("movieId") int movieId) {
        service.deleteMovie(movieId);
    }
}