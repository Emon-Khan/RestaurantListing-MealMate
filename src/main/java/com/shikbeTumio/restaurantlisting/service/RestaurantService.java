package com.shikbeTumio.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shikbeTumio.restaurantlisting.dto.RestaurantDTO;
import com.shikbeTumio.restaurantlisting.entity.Restaurant;
import com.shikbeTumio.restaurantlisting.mapper.RestaurantMapper;
import com.shikbeTumio.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepo.findAll();
		// map Restaurant with RestaurantDTO
		List<RestaurantDTO> restaurantDTOList = restaurants.stream()
				.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
				.collect(Collectors.toList());
		return restaurantDTOList;
	}

	public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant savedRestaurant = restaurantRepo
				.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
	}

	public ResponseEntity<RestaurantDTO> getRestaurantById(Integer id) {
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if (restaurant.isPresent()) {
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
