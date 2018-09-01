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

    public Set<Node> getDestinations(Node node) {
        Set<Node> result = null;
        if (isContainNode(node)) {
            result = node.getDestinations();
        }
        return result;
    }

    private boolean isContainNode(Node searchedNode) {
        for (Node node : nodes) {
            if (node.getName().equalsIgnoreCase(searchedNode.getName())) {
                return true;
            }
        }
        return false;
    }
}
