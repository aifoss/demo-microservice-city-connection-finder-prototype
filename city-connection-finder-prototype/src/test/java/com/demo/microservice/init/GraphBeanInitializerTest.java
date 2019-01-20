package com.demo.microservice.init;

import static com.demo.microservice.util.TestUtil.GRAPH;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.demo.microservice.model.Graph;
import com.demo.microservice.service.CityGraphBuilderService;

/**
 * Unit test for {@link GraphBeanInitializer}.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class GraphBeanInitializerTest {
	
	@InjectMocks
	private GraphBeanInitializer graphBeanInitializer;
	
	@Mock
	private CityGraphBuilderService cityGraphBuilderService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_graph() throws IOException {
		when(cityGraphBuilderService.buildGraph()).thenReturn(GRAPH);
		
		Graph graph = graphBeanInitializer.graph();
		
		assertEquals(GRAPH, graph);
	}
	
}
