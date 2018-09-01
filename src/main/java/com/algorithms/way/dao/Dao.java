package com.algorithms.way.dao;

import com.algorithms.way.model.Graph;
import com.algorithms.way.model.Node;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Getter
public class Dao {

    private final String PATH;
    private final Graph GRAPH;
    private final List<String> DESTINATION;

    public Dao(Graph GRAPH) {
        this.GRAPH = GRAPH;
        this.PATH = "src/main/resources/cities.txt";
        this.DESTINATION = fileReader();
    }

    private List<String> fileReader() {
        List<String> startEndCities = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File(PATH));
            while (input.hasNextLine()) {
                String[] line = input.nextLine().split("\\s+");
                if (line.length == 2) {
                    startEndCities.add(line[0]);
                    startEndCities.add(line[1]);
                } else if (line.length == 3) {
                    getAddNode(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return startEndCities;
    }

    private void getAddNode(String[] line) {
        Node firstCity = GRAPH.getNode(new Node(line[0]));
        Node secondCity = GRAPH.getNode(new Node(line[1]));

        GRAPH.getNode(firstCity).addAdjacent(secondCity, Integer.valueOf(line[2]));
        GRAPH.getNode(secondCity).addAdjacent(firstCity, Integer.valueOf(line[2]));   //bidirectional
    }
}
