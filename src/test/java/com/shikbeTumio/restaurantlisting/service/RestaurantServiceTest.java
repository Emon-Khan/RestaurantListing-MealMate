package com.shikbeTumio.restaurantlisting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shikbeTumio.restaurantlisting.dto.RestaurantDTO;
import com.shikbeTumio.restaurantlisting.entity.Restaurant;
import com.shikbeTumio.restaurantlisting.mapper.RestaurantMapper;
import com.shikbeTumio.restaurantlisting.repo.RestaurantRepo;

public class RestaurantServiceTest {

	@Mock
	RestaurantRepo restaurantRepo;

	@InjectMocks
	RestaurantService restaurantService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllRestaurants() {
		List<Restaurant> mockRestaurants = Arrays.asList(
				new Restaurant(1, "Demo Restaurant 1", "Address 1", "Demo City 1",
						"This is the demo for the first demo restaurant"),
				new Restaurant(2, "Demo Restaurant 2", "Address 2", "Demo City 2",
						"This is the demo for the second demo restaurant"));

		when(restaurantRepo.findAll()).thenReturn(mockRestaurants);

		List<RestaurantDTO> restaurantDTOList = restaurantService.getAllRestaurants();

		assertEquals(mockRestaurants.size(), restaurantDTOList.size());
		List<RestaurantDTO> mockDTOList = mockRestaurants.stream()
				.map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant))
				.collect(Collectors.toList());
		assertEquals(mockDTOList, restaurantDTOList);

		verify(restaurantRepo, times(1)).findAll();

	}

	@Test
	public void testCreateRestaurant() {
		RestaurantDTO mockRestaurantDTO = new RestaurantDTO(1, "Demo Restaurant 1", "Address 1", "Demo City 1",
				"This is the demo for the first demo restaurant");
		Restaurant mockRestaurant = RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(mockRestaurantDTO);
		when(restaurantRepo.save(mockRestaurant)).thenReturn(mockRestaurant);

		RestaurantDTO savedRestaurantDTO = restaurantService.createRestaurant(mockRestaurantDTO);

		assertEquals(mockRestaurantDTO, savedRestaurantDTO);

		verify(restaurantRepo, times(1)).save(mockRestaurant);

	}

	@Test
	public void testGetRestaurantById_ExistingId() {
		Integer mockeRestaurantId = 1;
		Optional<Restaurant> mockRestaurant = Optional.ofNullable(new Restaurant(1, "Demo Restaurant 1", "Address 1",
				"Demo City 1", "This is the demo for the first demo restaurant"));
		when(restaurantRepo.findById(mockeRestaurantId)).thenReturn(mockRestaurant);

		ResponseEntity<RestaurantDTO> response = restaurantService.getRestaurantById(mockeRestaurantId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(mockRestaurant.get()), response.getBody());

		verify(restaurantRepo, times(1)).findById(mockeRestaurantId);

	}

	@Test
	public void testGetRestaurantById_NonExistingId() {
		Integer mockeRestaurantId = 2;
		when(restaurantRepo.findById(mockeRestaurantId)).thenReturn(Optional.empty());

		ResponseEntity<RestaurantDTO> response = restaurantService.getRestaurantById(mockeRestaurantId);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertNull(response.getBody());

		verify(restaurantRepo, times(1)).findById(mockeRestaurantId);

	}
}
