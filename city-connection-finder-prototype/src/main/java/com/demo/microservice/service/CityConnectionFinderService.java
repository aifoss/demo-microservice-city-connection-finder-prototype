package com.demo.microservice.service;

/**
 * Interface declaring methods for service for checking connections between cities.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public interface CityConnectionFinderService {

	/**
	 * Checks a connection between 2 given cities.
	 * 
	 * @param origin origin city
	 * @param destination destination city
	 * @return true if connection exists between origin and destination; false otherwise
	 */
	boolean findConnection(String origin, String destination);
	
}
