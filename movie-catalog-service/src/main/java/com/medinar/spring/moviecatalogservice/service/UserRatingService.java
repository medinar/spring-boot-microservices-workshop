package com.medinar.spring.moviecatalogservice.service;

import com.medinar.spring.moviecatalogservice.model.Rating;
import com.medinar.spring.moviecatalogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rommelmedina
 */
@Service
public class UserRatingService {
    
    @Autowired
    RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject(
                "http://ratings-data-service/ratings/users/" + userId,
                UserRating.class
        );
    }
    
    public UserRating getFallbackUserRating(String userId) {
        return new UserRating(userId, Arrays.asList(new Rating("0", 0)));
    }    
}
