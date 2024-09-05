package com.shikbeTumio.restaurantlisting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shikbeTumio.restaurantlisting.dto.RestaurantDTO;
import com.shikbeTumio.restaurantlisting.service.RestaurantService;

public class RestaurantControllerTest {

	@InjectMocks
	RestaurantController restaurantController;

	@Mock
	RestaurantService restaurantService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllRestaurants() {
		List<RestaurantDTO> mockRestaurants = Arrays.asList(
				new RestaurantDTO(1, "Demo Restaurant 1", "Address 1", "Demo City 1",
						"This is the demo for the first demo restaurant"),
				new RestaurantDTO(2, "Demo Restaurant 2", "Address 2", "Demo City 2",
						"This is the demo for the second demo restaurant"));

		when(restaurantService.getAllRestaurants()).thenReturn(mockRestaurants);

		ResponseEntity<List<RestaurantDTO>> response = restaurantController.getAllRestaurants();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockRestaurants, response.getBody());

		verify(restaurantService, times(1)).getAllRestaurants();
	}

	@Test
	public void testCreateRestaurant() {

		RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Demo Restaurant 1", "Address 1", "Demo City 1",
				"This is the demo for the first demo restaurant");

		when(restaurantService.createRestaurant(mockRestaurant)).thenReturn(mockRestaurant);

		ResponseEntity<RestaurantDTO> response = restaurantController.createRestaurant(mockRestaurant);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockRestaurant, response.getBody());

		verify(restaurantService, times(1)).createRestaurant(mockRestaurant);
	}

	@Test
	public void testGetRestaurantById() {

		Integer mockRestaurantId = 1;

		RestaurantDTO mockRestaurant = new RestaurantDTO(1, "Demo Restaurant 1", "Address 1", "Demo City 1",
				"This is the demo for the first demo restaurant");

		when(restaurantService.getRestaurantById(mockRestaurantId))
				.thenReturn(new ResponseEntity(mockRestaurant, HttpStatus.OK));

		ResponseEntity<RestaurantDTO> response = restaurantController.getRestaurantById(mockRestaurantId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockRestaurant, response.getBody());

		verify(restaurantService, times(1)).getRestaurantById(mockRestaurantId);
	}
}
