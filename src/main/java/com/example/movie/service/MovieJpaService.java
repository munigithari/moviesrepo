/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.movie.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.model.Movie;

@Service
public class MovieJpaService implements MovieRepository {

    @Autowired
    private MovieJpaRepository repository;

    @Override
    public ArrayList<Movie> getMovies() {
        List<Movie> list = repository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(list);

        return movies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        try {
            Movie movies = repository.findById(movieId).get();
            return movies;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        repository.save(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie movies = repository.findById(movieId).get();
            if (movie.getMovieName() != null) {
                movies.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                movies.setLeadActor(movie.getLeadActor());
            }
            repository.save(movies);
            return movies;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        try {
            repository.deleteById(movieId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}