package com.algorithms.way.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Node {

    private final String name;
    private Integer distance;
    private LinkedList<Node> shortestPath;
    private Map<Node, Integer> adjacents;

    public Node(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
        this.shortestPath = new LinkedList<>();
        this.adjacents = new HashMap<>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addAdjacent(Node newNode, Integer distance) {
        if (!isContainNode(newNode)) {
            this.adjacents.put(newNode, distance);
        }
    }

    private boolean isContainNode(Node searchedNode) {
        for (Node node : adjacents.keySet()) {
            if (node.name.equalsIgnoreCase(searchedNode.getName())) {
                return true;
            }
        }
        return false;
    }
}
