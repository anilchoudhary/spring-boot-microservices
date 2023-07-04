package dev.anil.movieinfoservice.controller;

import dev.anil.movieinfoservice.models.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class Controller {

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieInfo(@PathVariable String movieId){
        return new ResponseEntity<Movie>(new Movie(movieId, "Transformers"), HttpStatus.OK);
    }

}
