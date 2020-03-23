package com.medinar.spring.ratingsdataservice.resource;

import com.medinar.spring.ratingsdataservice.model.Rating;
import com.medinar.spring.ratingsdataservice.model.UserRating;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rommelmedina
 */
@RestController
@RequestMapping("/ratings")
public class RatingsResource {
    
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 7);
    }
    
    @RequestMapping("/users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        return new UserRating(
                userId, 
                Arrays.asList(
                        new Rating("100", 3), 
                        new Rating("200", 4)
                )
        );
    }
}
