package com.app.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Rating;
import com.app.repository.AverageRating;
import com.app.repository.RatingRepository;

@Service
public class RatingTask implements RatingService {
	
	@Autowired
	RatingRepository ratingRepo;
	
	@Autowired
	AverageRating averageRatingRepo;
	
	

	@Override
	public com.app.model.AverageRating getAverageRating(Integer userId) {
		com.app.model.AverageRating avgRating = averageRatingRepo.getAverageRating(userId);
		
		return avgRating;
	}

	@Override
	public void updateRating(Integer driverId, Integer passengerId, Integer ratingFrom, Integer rating) {
		

	}
    
	@Override
	public void saveAverageRating(com.app.model.AverageRating newAvgRatingObj) {
		averageRatingRepo.save(newAvgRatingObj);
		
	}

	@Override
	public com.app.model.AverageRating getAverageRatingObj(Integer userId) {
		com.app.model.AverageRating avgRatingObj = averageRatingRepo.getAverageRating(userId);
		return avgRatingObj;
	}

	@Override
	public void saveRating(Rating rating) {
		ratingRepo.save(rating);
		
	}

}
