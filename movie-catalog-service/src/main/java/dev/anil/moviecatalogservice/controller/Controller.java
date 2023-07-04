package dev.anil.moviecatalogservice.controller;

import dev.anil.moviecatalogservice.models.CatalogItem;
import dev.anil.moviecatalogservice.models.Movie;
import dev.anil.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public ResponseEntity<List<CatalogItem>> getMovieCatalog(@PathVariable("userId") String userId){
        List<Rating> ratingsList = Arrays.asList(
                new Rating("1234", 3),
                new Rating("5678", 4)
        );
        List<CatalogItem> response;
        response = ratingsList.stream().map(rating -> {
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+rating.getMovieId(), Movie.class);
            Movie movie = webClientBuilder.build().get().uri("http://localhost:8081/movies/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
            return new CatalogItem(movie.getName(),"description", rating.getRating());
        }).collect(Collectors.toList());

        return new ResponseEntity<List<CatalogItem>>(response, HttpStatus.OK);
    }

}
