import java.util.ArrayList;
import java.util.Scanner;

public class GraphCycleDetection {
    private int vertices; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjList; // Adjacency list representation

    // Constructor to initialize the graph
    public GraphCycleDetection(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Undirected graph, so add both u->v and v->u
    }

    // DFS function to detect a cycle
    private boolean dfs(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true; // Mark the current vertex as visited

        // Traverse all adjacent vertices
        for (int adjacent : adjList.get(vertex)) {
            // If the adjacent vertex is not visited, make a recursive call
            if (!visited[adjacent]) {
                if (dfs(adjacent, visited, vertex)) {
                    return true; // Cycle found
                }
            }
            // If the adjacent vertex is visited and is not the parent of the current vertex, cycle exists
            else if (adjacent != parent) {
                return true;
            }
        }
        return false; // No cycle found
    }

    // Function to check if the graph contains a cycle
    public boolean containsCycle() {
        boolean[] visited = new boolean[vertices]; // Initialize visited array

        // Run DFS for all unvisited vertices to check for cycles
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) { // -1 denotes no parent for the starting node
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices and edges
        System.out.println("Enter number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int E = scanner.nextInt();

        GraphCycleDetection graph = new GraphCycleDetection(V);

        // Input edges
        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        // Check if the graph contains a cycle
        if (graph.containsCycle()) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }

        scanner.close();
    }
}
