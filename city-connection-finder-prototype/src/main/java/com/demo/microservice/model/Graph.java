package com.demo.microservice.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Data model to represent a graph where a node represents a city
 * and an edge represents a direct path between 2 cities.
 * 
 * @author sofia
 * @date 2019-01-19
 */
public class Graph {

    private Set<String> nodeSet;
    private Map<String, Set<String>> adjMap;

    public Graph() {
        nodeSet = new HashSet<>();
        adjMap = new HashMap<>();
    }
    
    public Graph(Set<String> nodeSet, Map<String, Set<String>> adjMap) {
    	this.nodeSet = nodeSet;
    	this.adjMap = adjMap;
    }

    public void addEdge(String v, String w) {
        nodeSet.add(v);
        nodeSet.add(w);

        adjMap.computeIfAbsent(v, k -> new HashSet<>()).add(w);
        adjMap.computeIfAbsent(w, k -> new HashSet<>()).add(v);
    }

    public Set<String> getNodeSet() {
        return nodeSet;
    }

    public void setNodeSet(Set<String> nodeSet) {
        this.nodeSet = nodeSet;
    }

    public Map<String, Set<String>> getAdjMap() {
        return adjMap;
    }

    public void setAdjMap(Map<String, Set<String>> adjMap) {
        this.adjMap = adjMap;
    }

    @Override
    public String toString() {
    	return adjMap.toString();
    }
    
}
