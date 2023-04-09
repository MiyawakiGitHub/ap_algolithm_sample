package DepthpFirstSearch;

import java.util.ArrayList;
import java.util.List;

/*
 * このコードは、6つの頂点を持つ無向グラフを表しており、
 * Graph クラスの dfs メソッドで深さ優先探索を実行しています。
 * visited 配列は、訪問済みの頂点を記録するために使用されます。
 */

public class DepthFirstSearch {

    static class Graph {
        int vertices;
        List<Integer>[] adjacencyList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new ArrayList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }

        void addEdge(int src, int dest) {
            adjacencyList[src].add(dest);
            adjacencyList[dest].add(src);
        }

        void dfs(int startVertex, boolean[] visited) {
            visited[startVertex] = true;
            System.out.print(startVertex + " ");

            for (Integer vertex : adjacencyList[startVertex]) {
                if (!visited[vertex]) {
                    dfs(vertex, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        boolean[] visited = new boolean[vertices];
        System.out.println("Depth-First Search starting from vertex 0:");
        graph.dfs(0, visited);
    }
}