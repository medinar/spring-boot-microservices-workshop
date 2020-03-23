package com.medinar.spring.moviecatalogservice.service;

import com.medinar.spring.moviecatalogservice.model.CatalogItem;
import com.medinar.spring.moviecatalogservice.model.Movie;
import com.medinar.spring.moviecatalogservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rommelmedina
 */
@Service
public class MovieInfoService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getFallbackCatalogItem",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                @HystrixProperty(name = "coreSize", value = "20"),
                @HystrixProperty(name = "maxQueueSize", value = "10")
            }
    )
    public CatalogItem getCatalogItem(Rating rating) {
        Movie movie = restTemplate.getForObject(
                "http://movie-info-service/movies/" + rating.getMovieId(),
                Movie.class
        );
        return new CatalogItem(
                movie.getName(),
                movie.getDescription(),
                rating.getRating()
        );
    }

    public CatalogItem getFallbackCatalogItem(Rating rating) {
        return new CatalogItem("Movie name not found", "", 0);
    }

}
