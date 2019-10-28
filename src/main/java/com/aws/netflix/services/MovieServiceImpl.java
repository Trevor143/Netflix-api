package com.aws.netflix.services;

import com.aws.netflix.exceptions.NotFoundException;
import com.aws.netflix.models.Category;
import com.aws.netflix.models.Movie;
import com.aws.netflix.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    public MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    //find all movies
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    //create movie
    @Override
    public Movie create(Movie Movie) {
        System.out.println(Movie.getCategory());
        return movieRepository.save(Movie);
    }

    //find movies by id
    @Override
    public Movie findByID(Long id) {
        return movieRepository.findById(id).orElseThrow(()->
                new NotFoundException("Movie id" + id + "not found"));
    }

    @Override
    public Movie update(Long id, Movie Movie) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
