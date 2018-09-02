import com.algorithms.way.algorithm.Dijkstra;
import com.algorithms.way.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DijkstraTest {

    private Node node;
    private Dijkstra dijkstra;

    @BeforeEach
    void setUp() {
        node = new Node("Warsaw");
        dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(node);
    }

    @Test
    void testIfVisitedAllNodes() {
        assertEquals(1, dijkstra.getVisited().size());
    }

    @Test
    void testIfUnvisitedIsClear() {
        assertEquals(0, dijkstra.getUnvisited().size());
    }
}