import com.algorithms.way.dao.Dao;
import com.algorithms.way.model.Graph;
import com.algorithms.way.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DaoTest {

    private Dao dao;

    @BeforeEach
    void setUp() {
        dao = new Dao(new Graph());
    }

    @Test
    void testIfGetDestination() {
        assertEquals("Warsaw",dao.getDESTINATION().get(0));
    }
}