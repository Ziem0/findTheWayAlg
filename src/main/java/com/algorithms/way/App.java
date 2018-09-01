package com.algorithms.way;


import com.algorithms.way.algorithm.Dijkstra;
import com.algorithms.way.dao.Dao;
import com.algorithms.way.model.Graph;
import com.algorithms.way.model.Node;

public class App {

    public static void main(String[] args) {

        Graph graph = new Graph();
        Dao dao = new Dao(graph);
        Dijkstra dijkstra = new Dijkstra();

        Node startCity = graph.getNode(new Node(dao.getDESTINATION().get(0)));
        Node destination = graph.getNode(new Node(dao.getDESTINATION().get(1)));

        dijkstra.calculateShortestPath(startCity);

        System.out.println(graph.getNode(destination).getName());
        System.out.println(graph.getNode(destination).getShortestPath());
        System.out.println(graph.getNode(destination).getDistance());
    }
}
