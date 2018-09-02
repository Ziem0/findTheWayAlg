import com.algorithms.way.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private Node node;
    private Node adjacentNode;


    @BeforeEach
    void setUp() {
        node = new Node("Warsaw");
        adjacentNode = new Node("Paris");
        node.addAdjacent(adjacentNode, 100);
    }

    @Test
    void testIfAddAdjacent() {
        assertEquals(node.getAdjacents().keySet().size(),1);
    }


    @Test
    void testIfGetCorrectName() {
        assertEquals(node.toString(), "Warsaw");
    }


    @Test
    void testIfGetShortestPath() {
        assertThrows(IndexOutOfBoundsException.class, () -> node.getShortestPath().get(0));
    }


}