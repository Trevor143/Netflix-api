package com.aws.netflix.services;

import com.aws.netflix.exceptions.NotFoundException;
import com.aws.netflix.models.Category;
import com.aws.netflix.models.Movie;
import com.aws.netflix.models.MovieType;
import com.aws.netflix.models.User;
import com.aws.netflix.repositories.MovieRepository;
import com.aws.netflix.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    public MovieRepository movieRepository;
    public UserRepository userRepository;

    public MovieServiceImpl(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
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

    //querymovie
    @Override
    public List<Movie> findByCategoryAndType(Long id, MovieType type) {
        System.out.println(type);
        System.out.println(MovieType.suggested);
        return movieRepository.findByCategoryAndMovieType(new Category(id), type);
    }

    @Override
    public Movie update(Long id, Long userid, Movie Movie)
    {
        Movie movie = findByID(id);
        Optional<User> user = userRepository.findById(userid);
        if (movie.getUser().getId().equals(userid)){
            movie.setMovieName(Movie.getMovieName());
            movie.setReleaseYear(Movie.getReleaseYear());
            movie.setCategory(Movie.getCategory());
            return movieRepository.save(movie);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
