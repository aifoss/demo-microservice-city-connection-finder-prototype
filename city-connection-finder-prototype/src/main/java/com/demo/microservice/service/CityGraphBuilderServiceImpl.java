package com.demo.microservice.service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.demo.microservice.model.Graph;

/**
 * Implementation of {@link CityGraphBuilderService} interface.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@Service("city-graph-builder-service")
public class CityGraphBuilderServiceImpl implements CityGraphBuilderService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CityGraphBuilderServiceImpl.class);
	
	private static final String INPUT_FILE_PATH = "classpath:city.txt";
	private static final String DELIMITER = ", ";
	
	@Override
	public Graph buildGraph() throws IOException {
		LOGGER.info("Starting to build graph ...");
		
		Graph graph = new Graph();
		
		File file = ResourceUtils.getFile(INPUT_FILE_PATH);
		Scanner scanner = new Scanner(file);
		
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            String[] cityNames = line.split(DELIMITER);
            if (cityNames.length != 2) {
                continue;
            }

            graph.addEdge(cityNames[0].trim(), cityNames[1].trim());
        }

        scanner.close();

        LOGGER.info("Graph: {}", graph);
        
        LOGGER.info("Graph building complete");
        
        return graph;
    }
		
}
