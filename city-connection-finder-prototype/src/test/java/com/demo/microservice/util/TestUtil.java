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
		
		graph.addEdge("Boston", "New York");
		graph.addEdge("Philadelphia", "Newark");
		graph.addEdge("Newark", "Boston");
		graph.addEdge("Trenton", "Albany");
		
		return graph;
	}
	
	public static String getApiUri(String origin, String destination) {
		return "/connected?origin=" + origin + "&destination=" + destination;
	}
	
	public static String getFullApiUri(String origin, String destination) {
		return "http://localhost:8080/connected?origin=" + origin + "&destination=" + destination;
	}
	
}
