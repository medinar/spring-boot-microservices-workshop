package com.medinar.spring.moviecatalogservice.resource;

import com.medinar.spring.moviecatalogservice.model.CatalogItem;
import com.medinar.spring.moviecatalogservice.model.Movie;
import com.medinar.spring.moviecatalogservice.model.UserRating;
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

        UserRating userRating = restTemplate.getForObject(
                "http://ratings-data-service/ratings/users/" + userId, 
                UserRating.class
        );

        return userRating.getUserRatings().stream().map(rating -> {
            // For each movie ID, call movie info service and get details
            Movie movie = restTemplate.getForObject(
                    "http://movie-info-service/movies/" + rating.getMovieId(),
                    Movie.class
            );

            // Put them all together
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());
        
    }
}