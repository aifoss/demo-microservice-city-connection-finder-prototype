package com.demo.microservice.controller.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demo.microservice.controller.CityConnectionFinderController;
import com.demo.microservice.service.CityConnectionFinderService;

/**
 * Unit test for {@link CityConnectionFinderController}.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class CityConnectionFinderControllerTest {

	@InjectMocks
	private CityConnectionFinderController cityConnectionFinderController;
	
	@Mock
	private CityConnectionFinderService cityConnectionFinderService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_checkIfConnectionExists_yes() {
		String origin = "Boston";
		String destination = "New York";
		
		when(cityConnectionFinderService.findConnection(origin, destination)).thenReturn(true);
		
		String result = cityConnectionFinderController.checkIfConnectionExists(origin, destination);
		
		assertEquals("yes", result);
	}
	
	@Test
	public void test_checkIfConnectionExists_no() {
		String origin = "Philadelphia";
		String destination = "Albany";
		
		when(cityConnectionFinderService.findConnection(origin, destination)).thenReturn(false);
		
		String result = cityConnectionFinderController.checkIfConnectionExists(origin, destination);
		
		assertEquals("no", result);
	}
	
}
