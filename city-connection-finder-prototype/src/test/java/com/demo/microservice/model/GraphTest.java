package com.demo.microservice.model;

import static com.demo.microservice.util.TestUtil.GRAPH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;;

/**
 * Unit test for {@link Graph}.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class GraphTest {
	
	@Test
	public void test() {
		assertEquals(6, GRAPH.getNodeSet().size());
		assertEquals(6, GRAPH.getAdjMap().size());
		assertTrue(GRAPH.getNodeSet().contains("New York"));
		assertFalse(GRAPH.getNodeSet().contains("Paris"));
		assertEquals(1, GRAPH.getAdjMap().get("Philadelphia").size());
		assertTrue(GRAPH.getAdjMap().get("Philadelphia").contains("Newark"));
		assertEquals(2, GRAPH.getAdjMap().get("Boston").size());
		assertTrue(GRAPH.getAdjMap().get("Boston").contains("Newark"));
		assertTrue(GRAPH.getAdjMap().get("Boston").contains("New York"));
		assertFalse(GRAPH.getAdjMap().get("Boston").contains("Albany"));
	}

}
