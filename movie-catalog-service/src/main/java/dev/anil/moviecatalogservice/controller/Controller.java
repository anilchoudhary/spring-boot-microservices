package dev.anil.moviecatalogservice.controller;

import dev.anil.moviecatalogservice.models.CatalogItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class Controller {

    @GetMapping("/{userId}")
    public ResponseEntity<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId){
        return new ResponseEntity<CatalogItem>(new CatalogItem("Transformers","Description",4), HttpStatus.OK);
    }

}
