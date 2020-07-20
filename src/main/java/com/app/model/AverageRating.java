package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AverageRating {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	
	private Long rideCount;
	private Integer userId;
	private Double ratingSum;
	private Double avgRating;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Long getRideCount() {
		return rideCount;
	}
	public void setRideCount(Long rideCount) {
		this.rideCount = rideCount;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Double getRatingSum() {
		return ratingSum;
	}
	public void setRatingSum(Double ratingSum) {
		this.ratingSum = ratingSum;
	}
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	
	@Override
	public String toString() {
		return "AverageRating [Id=" + Id + ", rideCount=" + rideCount + ", userId=" + userId + ", ratingSum="
				+ ratingSum + ", avgRating=" + avgRating + "]";
	}
	
	
}
