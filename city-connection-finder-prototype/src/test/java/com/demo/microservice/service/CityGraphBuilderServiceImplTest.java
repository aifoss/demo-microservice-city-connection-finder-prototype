package com.demo.microservice.service;

import static com.demo.microservice.util.TestUtil.GRAPH;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.demo.microservice.model.Graph;

/**
 * Unit test for {@link CityGraphBuilderServiceImpl}.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class CityGraphBuilderServiceImplTest {
	
	@InjectMocks
	private CityGraphBuilderServiceImpl cityGraphBuilderService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_buildGraph() throws IOException {
		Graph graph = cityGraphBuilderService.buildGraph();

		assertEquals(GRAPH.getNodeSet(), graph.getNodeSet());
		assertEquals(GRAPH.getAdjMap(), graph.getAdjMap());
	}
	
}
