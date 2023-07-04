package dev.anil.moviecatalogservice.models;

import lombok.Data;

import java.util.List;

@Data
public class UserRatings {
    private List<Rating> userRatings;
}
