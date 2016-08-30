package com.test.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.test.domain.Hotel;
import com.test.domain.Review;

interface ReviewRepository extends Repository<Review, Long> {

	Page<Review> findByHotel(Hotel hotel, Pageable pageable);

	Review findByHotelAndIndex(Hotel hotel, int index);

	Review save(Review review);

}
