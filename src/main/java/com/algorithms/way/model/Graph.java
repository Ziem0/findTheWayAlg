package com.algorithms.way.model;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Graph {

    private Set<Node> nodes;

    public Graph() {
        this.nodes = new HashSet<>();
    }

    public Node getNode(Node newNode) {
        Node searchedNode = null;
        for (Node node : nodes) {
            if (newNode.getName().equalsIgnoreCase(node.getName())) {
                searchedNode = node;
            }
        }
        if (searchedNode == null) {
            nodes.add(newNode);
            searchedNode = newNode;
        }
        return searchedNode;
    }
}
