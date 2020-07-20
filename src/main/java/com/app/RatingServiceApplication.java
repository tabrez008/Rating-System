package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.RatingService.RatingTask;

@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
		
//		RatingTask t = new RatingTask();
//		System.out.println(t.getAverageRating(2));
	}

}
