package dev.anil.ratingsdataservice.controller;

import dev.anil.ratingsdataservice.models.Rating;
import dev.anil.ratingsdataservice.models.UserRatings;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class Controller {

    @GetMapping("/{movieId}")
    public ResponseEntity<Rating> getRatingByMovieId(@PathVariable("movieId") String movieId){
        return new ResponseEntity<>(new Rating(movieId, 4), HttpStatus.OK);
    }

//    @GetMapping("/users/{userId}")
//    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId){
//        List<Rating> ratingsList = Arrays.asList(
//                new Rating("1234", 3),
//                new Rating("5678", 4)
//        );
//        return new ResponseEntity<List<Rating>>(ratingsList,HttpStatus.OK);
//    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserRatings> getRatingByUserId(@PathVariable("userId") String userId){
        List<Rating> ratingsList = Arrays.asList(
                new Rating("1234", 3),
                new Rating("5678", 4)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setUserRatings(ratingsList);
        return new ResponseEntity<UserRatings>(userRatings,HttpStatus.OK);
    }
}
