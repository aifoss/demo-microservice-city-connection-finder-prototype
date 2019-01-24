package com.demo.microservice.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.microservice.model.Graph;

/**
 * Implementation of {@link CityConnectionFinderService} interface.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@Service("city-connection-finder-service")
public class CityConnectionFinderServiceImpl implements CityConnectionFinderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityConnectionFinderServiceImpl.class);

	@Autowired
	private Graph graph;

	@Override 
	public boolean findConnection(String origin, String destination) {
		origin = origin.toLowerCase();
		destination = destination.toLowerCase();
		
		LOGGER.info("Checking if connection exists between {{}} and {{}}", origin, destination);
		
		if (origin.equals(destination)) {
        	LOGGER.info("Identical city {{}} for origin and destination, returning positive response", origin);
            return true;
        }
		
		if (!graph.getNodeSet().contains(origin)) {
			LOGGER.info("Unrecognized origin: {{}}, returning negative response", origin);
			return false;
		}
		if (!graph.getNodeSet().contains(destination)) {
			LOGGER.info("Unrecognized destination: {{}}, returning negative response", destination);
			return false;
		}
		
        if (graph.getAdjMap().get(origin).contains(destination)) {
        	LOGGER.info("Diret path exists, returning positive response");
        	return true;
        }
        
        return findIndirectConnection(origin, destination);
    }
		
	protected boolean findIndirectConnection(String origin, String destination) {
		Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        visited.add(origin);
        q.add(origin);

        while (!q.isEmpty()) {
            String node = q.remove();

            for (String adj : graph.getAdjMap().get(node)) {
                if (adj.equals(destination)) {
                	LOGGER.info("Connection found, returning positive response");
                    return true;
                }

                if (!visited.contains(adj)) {
                    visited.add(adj);
                    q.add(adj);
                }
            }
        }
        
        LOGGER.info("Connection not found, returning negative response");

        return false;
	}
	
}
