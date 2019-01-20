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
		assertTrue(GRAPH.getNodeSet().contains("new york"));
		assertFalse(GRAPH.getNodeSet().contains("paris"));
		assertEquals(1, GRAPH.getAdjMap().get("philadelphia").size());
		assertTrue(GRAPH.getAdjMap().get("philadelphia").contains("newark"));
		assertEquals(2, GRAPH.getAdjMap().get("boston").size());
		assertTrue(GRAPH.getAdjMap().get("boston").contains("newark"));
		assertTrue(GRAPH.getAdjMap().get("boston").contains("new york"));
		assertFalse(GRAPH.getAdjMap().get("boston").contains("albany"));
	}

}
