package com.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.domain.City;
import com.test.domain.HotelSummary;

public interface CityService {

	Page<City> findCities(CitySearchCriteria criteria, Pageable pageable);

	City getCity(String name, String country);

	Page<HotelSummary> getHotels(City city, Pageable pageable);

}
