
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {

    private Graph graph;

    @Before
	public void setUp() throws Exception {
        graph = new Graph();
	}

	@After
	public void tearDown() throws Exception {
        graph = null;
	}

    /**
     * Testing for correct implementation of addEdge
     */
    @Test
    public void testAddEdge() {
        try {
            assertTrue(graph.addEdge(new Town("Town1"), new Town("Town2"), 2, "Road1") != null);
        } catch (Exception e) {
            fail("addEdge threw an exception");
        }
        try {
            assertTrue(graph.addEdge(new Town("Town1"), new Town("Town2"), 2, "Road1") != null);
        } catch (Exception e) {
            fail("addEdge threw an exception");
        }
    }

    /**
     * Testing for correct implementation of addVertex
     */
    @Test
    public void testAddVertex() {
        try {
            assertTrue(graph.addVertex(new Town("Town1")));
        } catch (Exception e) {
            fail("addVertex threw an exception");
        }
        try {
            assertFalse(graph.addVertex(new Town("Town1")));
        } catch (Exception e) {
            fail("addVertex threw an exception");
        }
    }

    /**
     * Testing for correct implementation of containsEdge
     */
    @Test
    public void testContainsEdge() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        graph.addVertex(town1);
        graph.addVertex(town2);
        graph.addEdge(town1, town2, 2, "Road1");
        assertTrue(graph.containsEdge(town1, town2));
    }

    /**
     * Testing for correct implementation of containsVertex
     */
    @Test
    public void testContainsVertex() {
        Town town1 = new Town("Town1");
        graph.addVertex(town1);
        assertTrue(graph.containsVertex(town1));
    }

    /**
     * Testing for correct implementation of getEdge
     */
    @Test
    public void testGetEdge() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        graph.addVertex(town1);
        graph.addVertex(town2);
        graph.addEdge(town1, town2, 2, "Road1");
        assertTrue(graph.getEdge(town1, town2).getName().equals("Road1"));
    }

    /**
     * Testing for correct implementation of edgeSet
     */
    @Test
    public void testEdgeSet() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        graph.addVertex(town1);
        graph.addVertex(town2);
        graph.addEdge(town1, town2, 2, "Road1");
        assertTrue(graph.edgeSet().size() == 1);
    }

    /**
     * Testing for correct implementation of vertexSet
     */
    @Test
    public void testVertexSet() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        graph.addVertex(town1);
        graph.addVertex(town2);
        assertTrue(graph.vertexSet().size() == 2);
    }

    /**
     * Testing for correct implementation of edgesOf
     */
    @Test
    public void testEdgesOf() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        graph.addVertex(town1);
        graph.addVertex(town2);
        graph.addEdge(town1, town2, 2, "Road1");
        assertTrue(graph.edgesOf(town1).size() == 1);
    }

    /**
     * Testing for correct implementation of removeEdge
     */
    @Test
    public void testRemoveEdge() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        graph.addVertex(town1);
        graph.addVertex(town2);
        graph.addEdge(town1, town2, 2, "Road1");
        assertTrue(graph.removeEdge(town1, town2, 2, "Road1") != null);
    }

    /**
     * Testing for correct implementation of removeVertex
     */
    @Test
    public void testRemoveVertex() {
        Town town1 = new Town("Town1");
        graph.addVertex(town1);
        assertTrue(graph.removeVertex(town1));
    }

    /**
     * Testing for correct implementation of shortestPath
     */
    @Test
    public void testShortestPath() {
        Town town1 = new Town("Town1");
        Town town2 = new Town("Town2");
        Town town3 = new Town("Town3");
        Town town4 = new Town("Town4");
        Town town5 = new Town("Town5");
        Town town6 = new Town("Town6");
        graph.addVertex(town1);
        graph.addVertex(town2);
        graph.addVertex(town3);
        graph.addVertex(town4);
        graph.addVertex(town5);
        graph.addVertex(town6);
        graph.addEdge(town1, town2, 2, "Road1");
        graph.addEdge(town2, town3, 2, "Road2");
        graph.addEdge(town3, town4, 2, "Road3");
        graph.addEdge(town4, town5, 2, "Road4");
        graph.addEdge(town5, town6, 2, "Road5");
        assertTrue(graph.shortestPath(town1, town6).size() == 5);
    }


}
