package dev.anil.ratingsdataservice.controller;

import dev.anil.ratingsdataservice.models.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class Controller {

    @GetMapping("/{movieId}")
    public ResponseEntity<Rating> getRating(@PathVariable("movieId") String movieId){
        return new ResponseEntity<>(new Rating(movieId, 4), HttpStatus.OK);
    }
}
