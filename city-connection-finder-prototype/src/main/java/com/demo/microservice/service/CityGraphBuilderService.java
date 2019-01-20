package com.demo.microservice.service;

import java.io.IOException;

import com.demo.microservice.model.Graph;

/**
 * Interface declaring methods for service for building a graph of cities.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public interface CityGraphBuilderService {

	/**
	 * Builds a graph with cities as nodes and direct paths between cities as edges.
	 * 
	 * @return Graph 
	 * @throws IOException
	 */
	Graph buildGraph() throws IOException; 
	
}
