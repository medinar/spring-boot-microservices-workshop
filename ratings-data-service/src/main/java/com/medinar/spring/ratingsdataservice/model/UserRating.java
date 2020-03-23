package com.medinar.spring.ratingsdataservice.model;

import java.util.List;

/**
 *
 * @author rommelmedina
 */
public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public UserRating() {
    }

    public UserRating(String userId, List<Rating> ratings) {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserRating{userId=").append(userId);
        sb.append(", ratings=").append(ratings);
        sb.append('}');
        return sb.toString();
    }

}
