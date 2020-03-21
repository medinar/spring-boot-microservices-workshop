package com.medinar.spring.moviecatalogservice.resource;

import com.medinar.spring.moviecatalogservice.model.CatalogItem;
import com.medinar.spring.moviecatalogservice.model.Movie;
import com.medinar.spring.moviecatalogservice.model.Rating;
import com.medinar.spring.moviecatalogservice.model.UserRating;
import java.util.Arrays;
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

//    @Autowired
//    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject(
                "http://localhost:9003/ratings/users/" + userId, 
                UserRating.class
        );

        return userRating.getUserRatings().stream().map(rating -> {
            // For each movie ID, call movie info service and get details
            Movie movie = restTemplate.getForObject(
                    "http://localhost:9002/movies/" + rating.getMovieId(),
                    Movie.class
            );

            // Put them all together
            return new CatalogItem(movie.getName(), "Desc", rating.getRating());
        }).collect(Collectors.toList());
        
    }
}

//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:9002/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();