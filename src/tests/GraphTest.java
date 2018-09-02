import com.algorithms.way.model.Graph;
import com.algorithms.way.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GraphTest {

    private Graph graph;

    @Mock
    private Node node;

    @BeforeEach
    void setUp() {
        graph = new Graph();
        node = mock(Node.class);
        when(node.getName()).thenReturn("Warsaw");
        graph.getNode(node);
    }

    @Test
    void testIfGetNode() {
        assertEquals(graph.getNode(node).getName(), node.getName());
    }

    @Test
    void testIfGetNodes() {
        assertEquals(1, graph.getNodes().size());
    }

    @Test
    void testIfAddNewNode() {
        graph.getNodes().remove(node);
        graph.getNode(node);
        assertEquals(1, graph.getNodes().size());
    }
}