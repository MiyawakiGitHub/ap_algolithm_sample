package Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        List<Edge>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest, int weight) {
            adjacencyList[src].add(new Edge(dest, weight));
            adjacencyList[dest].add(new Edge(src, weight));
        }

        void dijkstra(int startVertex) {
            int[] distances = new int[vertices];
            boolean[] visited = new boolean[vertices];

            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0;

            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            priorityQueue.add(new Edge(startVertex, 0));

            while (!priorityQueue.isEmpty()) {
                Edge currentEdge = priorityQueue.poll();
                int currentVertex = currentEdge.dest;

                if (visited[currentVertex]) {
                    continue;
                }
                visited[currentVertex] = true;

                for (Edge edge : adjacencyList[currentVertex]) {
                    int dest = edge.dest;
                    int weight = edge.weight;

                    if (!visited[dest] && distances[currentVertex] + weight < distances[dest]) {
                        distances[dest] = distances[currentVertex] + weight;
                        priorityQueue.add(new Edge(dest, distances[dest]));
                    }
                }
            }

            System.out.println("Shortest distances from vertex " + startVertex + ":");
            for (int i = 0; i < vertices; i++) {
                System.out.println(i + " -> " + distances[i]);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 6);

        graph.dijkstra(0);
    }
}