package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.RatingService.RatingTask;
import com.app.exception.CustomException;
import com.app.model.AverageRating;
import com.app.model.Rating;

@RestController
@RequestMapping("/api")
public class RatingController {

	@Autowired
	RatingTask ratingTask;
	
	@GetMapping("/averageRating/{id}")
	private ResponseEntity<AverageRating> getAvgRating(@PathVariable("id") Integer id) {
		AverageRating avgRating = ratingTask.getAverageRating(id);
		if(avgRating != null) {
			return new ResponseEntity<AverageRating>(avgRating , HttpStatus.OK);
		}
		
		throw new CustomException(
				"Invaid UserId" ,
				"Please Provide Valid UserId",
				"Add Rating in the Rating Table");
	}
	
	@PostMapping("/updateRating")
	private ResponseEntity<AverageRating> updateRating(@RequestBody Rating rating) {
		
		Integer ratingFrom = rating.getRatingFrom();
		AverageRating newAvgRatingObj ;
		Double nextRating = rating.getRating();
		if(nextRating > 5) {
			throw new CustomException(
					"Invaid Rating" ,
					"Please Provide Valid Rating",
					"Rating Can Be Only Between 1 To 5 Inclusive"
					);
		}
		ratingTask.saveRating(rating);
		
		if(ratingFrom == 1) {
			AverageRating avgRating = ratingTask.getAverageRating(rating.getUserId());
			if(avgRating == null) {
				newAvgRatingObj = new AverageRating();
				newAvgRatingObj.setUserId(rating.getUserId());
				newAvgRatingObj.setAvgRating(rating.getRating());
				newAvgRatingObj.setRatingSum(rating.getRating());
				newAvgRatingObj.setRideCount((new Long(1)));
				ratingTask.saveAverageRating(newAvgRatingObj);
			}
			else {
				newAvgRatingObj = ratingTask.getAverageRatingObj(rating.getUserId());
				Long newRideCount = newAvgRatingObj.getRideCount() + 1;
				Double newRatingSum = newAvgRatingObj.getRatingSum() + rating.getRating();
				Double newAvgRating = newRatingSum / newRideCount;
				newAvgRatingObj.setAvgRating(newAvgRating);
				newAvgRatingObj.setRatingSum(newRatingSum);
				newAvgRatingObj.setRideCount(newRideCount);
				ratingTask.saveAverageRating(newAvgRatingObj);
			}
		}
		else if(ratingFrom == 2) {
			AverageRating avgRating = ratingTask.getAverageRating(rating.getDriverId());
			if(avgRating == null) {
				newAvgRatingObj = new AverageRating();
				newAvgRatingObj.setUserId(rating.getDriverId());
				newAvgRatingObj.setAvgRating(rating.getRating());
				newAvgRatingObj.setRatingSum(rating.getRating());
				newAvgRatingObj.setRideCount((new Long(1)));
				ratingTask.saveAverageRating(newAvgRatingObj);
			}
			else {
				newAvgRatingObj = ratingTask.getAverageRatingObj(rating.getDriverId());
				Long newRideCount = newAvgRatingObj.getRideCount() + 1;
				Double newRatingSum = newAvgRatingObj.getRatingSum() + rating.getRating();
				Double newAvgRating = newRatingSum / newRideCount;
				newAvgRatingObj.setAvgRating(newAvgRating);
				newAvgRatingObj.setRatingSum(newRatingSum);
				newAvgRatingObj.setRideCount(newRideCount);
				ratingTask.saveAverageRating(newAvgRatingObj);
			}
		}
		else 
			throw new CustomException(
					"Invaid RatingFrom Input" ,
					"Please Provide Valid Rating Input",
					"Please Note That It can Only Take Input As 1 Or 2"
					);
		
		return new ResponseEntity<AverageRating>(newAvgRatingObj , HttpStatus.CREATED);
	}
}
