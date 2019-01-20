package com.demo.microservice.util;

import com.demo.microservice.model.Graph;

/**
 * Utility for testing.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class TestUtil {
	
	public static final Graph GRAPH = createTestGraph();

	public static Graph createTestGraph() {
		Graph graph = new Graph();
		
		graph.addEdge("boston", "new york");
		graph.addEdge("philadelphia", "newark");
		graph.addEdge("newark", "boston");
		graph.addEdge("trenton", "albany");
		
		return graph;
	}
	
	public static String getApiUri(String origin, String destination) {
		return "/connected?origin=" + origin + "&destination=" + destination;
	}
	
}
