package com.app.RatingService;

import com.app.model.AverageRating;
import com.app.model.Rating;

public interface RatingService {

	public AverageRating getAverageRating(Integer userId);
	public void updateRating(Integer driverId , Integer passengerId , Integer ratingFrom , Integer rating);
	public void saveAverageRating(com.app.model.AverageRating newAvgRatingObj);
	public com.app.model.AverageRating getAverageRatingObj(Integer userId);
	public void saveRating(Rating rating);
}
