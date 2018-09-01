package com.algorithms.way.algorithm;

import com.algorithms.way.model.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Dijkstra {

    private Set<Node> unvisited;
    private Set<Node> visited;

    public Dijkstra() {
        this.unvisited = new HashSet<>();
        this.visited = new HashSet<>();
    }

    public void calculateShortestPath(Node source) {
        source.setDistance(0);

        this.unvisited.add(source);

        while (this.unvisited.size() > 0) {
            Node currentNode = getLowestDistanceNode();
            this.unvisited.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacents().entrySet()) {
                Node adjacencyNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();
                if (!this.visited.contains(adjacencyNode)) {
                    calculateMinimumDistance(adjacencyNode, edgeWeigh, currentNode);
                    this.unvisited.add(adjacencyNode);
                }
            }
            this.visited.add(currentNode);
        }
    }

    /**
     * It deals with adjacent nodes for current active node.
     * Update vertex values for adjacent nodes.
     * Update shortest path list based on previous (source) shortest path.
     */
    private void calculateMinimumDistance(Node evaluationNode, Integer evaluationEdgeWeigh, Node source) {
        Integer sourceDistance = source.getDistance();
        if (sourceDistance + evaluationEdgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + evaluationEdgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(source.getShortestPath());
            shortestPath.add(source);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    private Node getLowestDistanceNode() {    // finding the lowest vertex value node
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : this.unvisited) {
            Integer nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
}
