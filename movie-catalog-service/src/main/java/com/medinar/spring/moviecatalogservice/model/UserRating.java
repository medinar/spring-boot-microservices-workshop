package com.medinar.spring.moviecatalogservice.model;

import java.util.List;

/**
 *
 * @author rommelmedina
 */
public class UserRating {

    private List<Rating> userRatings;

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

}
