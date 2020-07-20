package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AverageRating extends JpaRepository<com.app.model.AverageRating, Integer>{
	
	@Query("SELECT ur FROM AverageRating ur where ur.userId=:userId")
	public com.app.model.AverageRating getAverageRating(@Param("userId") Integer userId);

}
