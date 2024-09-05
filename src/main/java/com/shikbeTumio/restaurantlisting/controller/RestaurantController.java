package com.shikbeTumio.restaurantlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shikbeTumio.restaurantlisting.dto.RestaurantDTO;
import com.shikbeTumio.restaurantlisting.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	@GetMapping("/restaurants")
	public ResponseEntity<List<RestaurantDTO>> getAllRestaurants() {
		List<RestaurantDTO> allRestaurants = restaurantService.getAllRestaurants();
		return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
	}

	@PostMapping("/restaurants")
	public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		RestaurantDTO restaurantAdded = restaurantService.createRestaurant(restaurantDTO);
		return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
	}

	@GetMapping("/restaurants/{id}")
	public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable Integer id) {
		return restaurantService.getRestaurantById(id);
	}
}
