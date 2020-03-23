package com.medinar.spring.moviecatalogservice.resource;

import com.medinar.spring.moviecatalogservice.model.CatalogItem;
import com.medinar.spring.moviecatalogservice.model.UserRating;
import com.medinar.spring.moviecatalogservice.service.MovieInfoService;
import com.medinar.spring.moviecatalogservice.service.UserRatingService;
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

    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    UserRatingService userRatingService;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {

        UserRating userRating = userRatingService.getUserRating(userId);
        return userRating.getRatings().stream()
                .map(rating -> {
                    return movieInfoService.getCatalogItem(rating);
                })
                .collect(Collectors.toList());

    }

}
