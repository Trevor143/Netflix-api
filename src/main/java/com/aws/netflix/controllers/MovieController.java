package com.aws.netflix.controllers;

import com.aws.netflix.models.Movie;
import com.aws.netflix.services.MovieService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping(value = "{id}")
    Movie findById(@PathVariable Long id) {
        return movieService.findByID(id);
    }

    @DeleteMapping(value = "{id}")
    String delete(@PathVariable Long id) {
        return movieService.delete(id);
    }

    @PatchMapping(value = "{id}")
    Movie update(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

}