package com.demo.microservice.init;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.demo.microservice.model.Graph;
import com.demo.microservice.service.CityGraphBuilderService;

/**
 * Initializer for Graph bean.
 * 
 * @author sofia
 * @date 2019-01-19
 */
@Component
public class GraphBeanInitializer {

	@Autowired
	private CityGraphBuilderService cityGraphBuilderService;

	@Bean
	public Graph graph() {
		try {
			return cityGraphBuilderService.buildGraph();
		} catch (IOException e) {
			throw new RuntimeException(String.format("Cannot build graph of cities... Abort!: %s", e.getMessage()));
		}
	}

}
