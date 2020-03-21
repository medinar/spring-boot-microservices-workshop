package com.medinar.spring.moviecatalogservice.resource;

import com.medinar.spring.moviecatalogservice.model.CatalogItem;
import com.medinar.spring.moviecatalogservice.model.Movie;
import com.medinar.spring.moviecatalogservice.model.Rating;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rommelmedina
 */
@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;
    
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {

        // get all rated movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 4)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject(
                    "http://localhost:9002/movies/" + rating.getMovieId(),
                    Movie.class
            );

            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());

        // For each movie ID, call movie info service and get details
        // Put them all together
    }
}
