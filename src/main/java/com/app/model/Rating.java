package com.app.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Rating {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
	
	private Integer userId;
	private Integer driverId;
	private Integer ratingFrom;
	private Double rating;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDriverId() {
		return driverId;
	}
	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}
	public Integer getRatingFrom() {
		return ratingFrom;
	}
	public void setRatingFrom(Integer ratingFrom) {
		this.ratingFrom = ratingFrom;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [Id=" + Id + ", userId=" + userId + ", driverId=" + driverId + ", ratingFrom=" + ratingFrom
				+ ", rating=" + rating + "]";
	}
	
	
}
