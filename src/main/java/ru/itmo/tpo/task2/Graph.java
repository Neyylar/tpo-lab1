package ru.itmo.tpo.task2;

import java.util.*;

public class Graph<T> {

    private Map<T, LinkedList<T>> graph = new HashMap<>();

    public Map<T, LinkedList<T>> getGraph() {
        return graph;
    }

    public Set<T> getVertices() {
        return graph.keySet();
    }

    private void setVertex(T vertex) {
        graph.put(vertex, new LinkedList<>());
    }

    public void setConnection(T leftVertex, T rightVertex) {
        if (!graph.containsKey(leftVertex)) {
            setVertex(leftVertex);
        }
        if (!graph.containsKey(rightVertex)) {
            setVertex(rightVertex);
        }
        graph.get(leftVertex).add(rightVertex);
    }

    public void setVertexConnections(T vertex, LinkedList<T> connections) {
        if (!connections.isEmpty()) connections.forEach((connection) -> setConnection(vertex, connection));
    }

    public void setAllConnections(LinkedList<LinkedList<T>> connections) {
        connections.forEach(connection -> {
            setVertexConnections(connection.removeFirst(), connection);
        });
    }

    public static <T> List<T> BSE(Graph<T> graph, T start) {
        List<T> path = new LinkedList<>();
        if (!graph.getVertices().contains(start)) {
            throw new IllegalArgumentException("Start vertex should be inside graph");
        }
        Map<T, Boolean> visited = new HashMap<>();
        for (T vertex : graph.getVertices()) {
            visited.put(vertex, Boolean.FALSE);
        }
        LinkedList<T> queue = new LinkedList<T>();
        T currVertex = start;
        queue.add(currVertex);
        while (queue.peek() != null) {
            visited.put(currVertex, Boolean.TRUE);
            currVertex = queue.remove();
            if (!graph.getGraph().containsKey(currVertex)) throw new IllegalArgumentException("Wrong connections of the graph");
            graph.getGraph().get(currVertex).forEach((x) -> {
                if (!visited.get(x)) queue.add(x);
            });
            if (!path.contains(currVertex)) path.add(currVertex);
        }
        return path;
    }
}



