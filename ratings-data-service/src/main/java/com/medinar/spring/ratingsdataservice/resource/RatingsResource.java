package com.medinar.spring.ratingsdataservice.resource;

import com.medinar.spring.ratingsdataservice.model.Rating;
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
}
