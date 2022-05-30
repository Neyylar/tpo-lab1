package ru.itmo.tpo.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GraphTest {
    private Graph<String> graph;
    private LinkedList<LinkedList<String>> connectionsString = new LinkedList<>();
    private LinkedList<LinkedList<String>> connectionsInt = new LinkedList<>();
    private LinkedList<LinkedList<String>> connectionsStringOneWay = new LinkedList<>();
    private LinkedList<LinkedList<String>> connectionsToItself = new LinkedList<>();
    private LinkedList<LinkedList<String>> connectionsMixedTypes = new LinkedList<>();
    private List<String> arr1 = new LinkedList(Arrays.asList("A", "B", "C", "D"));
    private List<String> arr2 = new LinkedList(Arrays.asList("B", "A", "C", "D"));
    private List<String> arr3 = new LinkedList(Arrays.asList("C", "B", "A", "D"));
    private List<String> arr4 = new LinkedList(Arrays.asList("D", "B", "A", "C"));

    private List<Integer> arr5 = new LinkedList(Arrays.asList("1", "2"));
    private List<Integer> arr6 = new LinkedList(Arrays.asList("2", "3"));
    private List<Integer> arr7 = new LinkedList(Arrays.asList("3", "2"));

    private List<Integer> arr8 = new LinkedList(Arrays.asList("1", "1"));
    private List<Integer> arr9 = new LinkedList(Arrays.asList("2", "2"));

    @BeforeEach
    void setUp() {
        connectionsString = new LinkedList(Arrays.asList(arr1, arr2, arr3, arr4));
        connectionsInt = new LinkedList(Arrays.asList(arr5, arr6, arr7));
        connectionsStringOneWay = new LinkedList(Arrays.asList(arr1, arr2));
        connectionsToItself = new LinkedList(Arrays.asList(arr8, arr9));
        connectionsMixedTypes = new LinkedList(Arrays.asList(arr1, arr8));
        this.graph = new Graph<String>();
        System.out.println("Test started. Graph initialized");
    }

    @Test
    void testWidthSearchStartsWithA() {
        LinkedList<String> outPath = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        graph.setAllConnections(connectionsString);
        assertEquals(outPath, Graph.BSE(graph, "A"));
    }
    @Test
    void testWidthSearchStartsWithD() {
        LinkedList<String> outPath = new LinkedList<>(Arrays.asList("D", "B", "A", "C"));
        graph.setAllConnections(connectionsString);
        assertEquals(outPath, Graph.BSE(graph, "D"));
    }
    @Test
    void testWidthSearchStartsWith1() {
        LinkedList<String> outPath = new LinkedList<>(Arrays.asList("1", "2", "3"));
        graph.setAllConnections(connectionsInt);
        assertEquals(outPath, Graph.BSE(graph, "1"));
    }
    @Test
    void testWidthSearchStartsWithWrongVertex() {
        graph.setAllConnections(connectionsInt);
        assertThrows(IllegalArgumentException.class, () -> Graph.BSE(graph, "A"));
    }
    @Test
    void testWidthSearchConnectionsStringOneWay() {
        LinkedList<String> outPath = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        graph.setAllConnections(connectionsStringOneWay);
        assertEquals(outPath, Graph.BSE(graph, "A"));
    }
    @Test
    void testWidthSearchConnectionToItself() {
        LinkedList<String> outPath = new LinkedList<>(Arrays.asList("1"));
        graph.setAllConnections(connectionsToItself);
        assertEquals(outPath, Graph.BSE(graph, "1"));
    }
    @Test
    void testWidthSearchConnectionMixedTypes() {
        LinkedList<String> outPath = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        graph.setAllConnections(connectionsMixedTypes);
        assertEquals(outPath, Graph.BSE(graph, "A"));
    }

    @Test
    void testSetConnection() {
        Set<String> vertices = new HashSet<>();
        vertices.add("A");
        vertices.add("B");
        Map<String, LinkedList<String>> graphTest = new HashMap<>();
        LinkedList<String> connections = new LinkedList<>(Arrays.asList("B"));
        graphTest.put("A", connections);
        graphTest.put("B",  new LinkedList());
        graph.setConnection("A", "B");
        assertEquals(vertices, graph.getVertices());
        assertEquals(graphTest, graph.getGraph());
    }

    @Test
    void testSetVertexConnections() {
        Set<String> vertices = new HashSet<>();
        vertices.add("A");
        vertices.add("B");
        vertices.add("C");
        vertices.add("D");
        Map<String, LinkedList<String>> graphTest = new HashMap<>();
        LinkedList<String> connections = new LinkedList<>(Arrays.asList("B", "C", "D"));
        graphTest.put("A", connections);
        graphTest.put("B",  new LinkedList());
        graphTest.put("C",  new LinkedList());
        graphTest.put("D",  new LinkedList());
        graph.setVertexConnections("A", connections);
        assertEquals(vertices, graph.getVertices());
        assertEquals(graphTest, graph.getGraph());
    }
}


