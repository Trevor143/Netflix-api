package com.aws.netflix.services;

import com.aws.netflix.models.Category;
import com.aws.netflix.models.Movie;
import com.aws.netflix.repositories.MovieRepository;

import java.util.List;

public interface MovieService {

    MovieRepository movieRepository = null;

    List<Movie> findAll();

    public Movie create(Movie Movie);

    Movie findByID(Long id);

    public Movie update(Long id, Movie Movie);

    public String delete(Long id);


}
