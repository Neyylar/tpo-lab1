package ru.itmo.tpo.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GraphTest {
    //TODO: Раставить модификаторы доступа
    private Graph<String> graph;
    LinkedList<LinkedList<String>> connectionsString = new LinkedList<>();
    LinkedList<LinkedList<String>> connectionsInt = new LinkedList<>();
    LinkedList<LinkedList<String>> connectionsStringOneWay = new LinkedList<>();
    LinkedList<LinkedList<String>> connectionsToItself = new LinkedList<>();
    LinkedList<LinkedList<String>> connectionsMixedTypes = new LinkedList<>();
    List<String> arr1 = new LinkedList(Arrays.asList("A", "B", "C", "D"));
    List<String> arr2 = new LinkedList(Arrays.asList("B", "A", "C", "D"));
    List<String> arr3 = new LinkedList(Arrays.asList("C", "B", "A", "D"));
    List<String> arr4 = new LinkedList(Arrays.asList("D", "B", "A", "C"));

    List<Integer> arr5 = new LinkedList(Arrays.asList("1", "2"));
    List<Integer> arr6 = new LinkedList(Arrays.asList("2", "3"));
    List<Integer> arr7 = new LinkedList(Arrays.asList("3", "2"));

    List<Integer> arr8 = new LinkedList(Arrays.asList("1", "1"));
    List<Integer> arr9 = new LinkedList(Arrays.asList("2", "2"));

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
}


