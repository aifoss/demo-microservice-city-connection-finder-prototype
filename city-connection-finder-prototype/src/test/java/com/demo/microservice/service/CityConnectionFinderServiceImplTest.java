package com.demo.microservice.service;

import static com.demo.microservice.util.TestUtil.GRAPH;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

/**
 * Unit test for {@link CityConnectionFinderServiceImpl}.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class CityConnectionFinderServiceImplTest {

	@InjectMocks
	private CityConnectionFinderServiceImpl cityConnectionFinderService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		cityConnectionFinderService.setGraph(GRAPH);
	}

	@Test
	public void test_findConnection_originEqualsDestination() {
		String origin = "New York";
		String destination = "New York";
		
		boolean result = cityConnectionFinderService.findConnection(origin, destination);
		
		assertTrue(result);
	}
	
	@Test
	public void test_findConnection_unrecognizedOrigin() {
		String origin = "Paris";
		String destination = "New York";
		
		boolean result = cityConnectionFinderService.findConnection(origin, destination);
		
		assertFalse(result);
	}
	
	@Test
	public void test_findConnection_unrecognizedDestination() {
		String origin = "New York";
		String destination = "Berlin";
		
		boolean result = cityConnectionFinderService.findConnection(origin, destination);
		
		assertFalse(result);
	}
	
	@Test
	public void test_findConnection_directConnection() {
		String origin = "Trenton";
		String destination = "Albany";
		
		boolean result = cityConnectionFinderService.findConnection(origin, destination);
		
		assertTrue(result);
	}
	
	@Test
	public void test_findIndirectConnection_true() {
		String origin = "Philadelphia";
		String destination = "Boston";

		boolean result = cityConnectionFinderService.findConnection(origin, destination);
		
		assertTrue(result);
	}

	@Test
	public void test_findIndirectConnection_false() {
		String origin = "Philadelphia";
		String destination = "Albany";
		
		boolean result = cityConnectionFinderService.findConnection(origin, destination);
		
		assertFalse(result);
	}
	
}
