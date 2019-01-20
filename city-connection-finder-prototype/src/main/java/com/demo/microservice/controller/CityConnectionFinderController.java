package com.demo.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservice.service.CityConnectionFinderService;

import io.swagger.annotations.ApiOperation;

/**
 * Controller for checking connections between cities.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@RestController
public class CityConnectionFinderController {

	@Autowired
	private CityConnectionFinderService cityConnectionFinderService;

	@ApiOperation(value = "Check whether or not two cities are connected", response = String.class)
	@GetMapping("/connected")
	public String checkIfConnectionExists(
			@RequestParam("origin") String origin, 
			@RequestParam("destination") String destination) {
		
		boolean connectionExists = cityConnectionFinderService.findConnection(origin, destination);
		
		return connectionExists ? "yes" : "no";
	}
	
}
