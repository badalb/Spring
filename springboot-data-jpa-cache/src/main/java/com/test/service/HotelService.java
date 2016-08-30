package com.test.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.domain.City;
import com.test.domain.Hotel;
import com.test.domain.Review;
import com.test.domain.ReviewDetails;

public interface HotelService {

	Hotel getHotel(City city, String name);

	Page<Review> getReviews(Hotel hotel, Pageable pageable);

	Review getReview(Hotel hotel, int index);

	Review addReview(Hotel hotel, ReviewDetails details);

	ReviewsSummary getReviewSummary(Hotel hotel);

}
