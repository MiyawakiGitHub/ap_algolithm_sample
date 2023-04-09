package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * このコードは、6つの頂点を持つ無向グラフを表しており、
 * Graph クラスの bfs メソッドで幅優先探索を実行しています。
 * visited 配列は、訪問済みの頂点を記録するために使用されます。
 * キューは、探索すべき頂点を保持し、BFSの順序に従って処理します。
 */

public class BreadthFirstSearch {

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

        void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[startVertex] = true;
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                int currentVertex = queue.poll();
                System.out.print(currentVertex + " ");

                for (Integer vertex : adjacencyList[currentVertex]) {
                    if (!visited[vertex]) {
                        visited[vertex] = true;
                        queue.add(vertex);
                    }
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

        System.out.println("Breadth-First Search starting from vertex 0:");
        graph.bfs(0);
    }
}
