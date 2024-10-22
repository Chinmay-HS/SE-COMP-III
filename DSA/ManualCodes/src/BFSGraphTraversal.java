import java.util.*;

// Class representing the graph
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list
    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        // Initialize each adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    // Add edge to the graph
    public void addEdge(int src, int dest) {
        adjList[src].add(dest); // Add dest to src's list
        adjList[dest].add(src); // Add src to dest's list for an undirected graph
    }
    // Perform BFS traversal
    public void BFS(int startVertex) {
        // Create a boolean array to mark visited vertices
        boolean visited[] = new boolean[vertices];
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();
        // Mark the current node as visited and enqueue it
        visited[startVertex] = true;
        queue.add(startVertex);
        System.out.println("BFS traversal starting from vertex " + startVertex + ":");
        // Loop until the queue is empty
        while (!queue.isEmpty()) {
            // Dequeue a vertex and print it
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            // Get all adjacent vertices of the dequeued vertex
            for (int adjVertex : adjList[currentVertex]) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
        System.out.println();
    }
    // Display the adjacency list (graph structure)
    public void displayGraph() {
        System.out.println("Graph adjacency list:");
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int adjVertex : adjList[i]) {
                System.out.print(adjVertex + " ");
            }
            System.out.println();
        }
    }
}
public class BFSGraphTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take the number of vertices from the user
        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = sc.nextInt();

        // Create a graph
        Graph graph = new Graph(vertices);
        System.out.println("\nGraph Operations Menu:");
        System.out.println("1. Add edge");
        System.out.println("2. Display graph (Adjacency list)");
        System.out.println("3. Perform BFS traversal");
        System.out.println("4. Exit");

        // User interaction menu
        while (true) {
            System.out.print("Choose an option (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add an edge to the graph
                    System.out.print("Enter source vertex: ");
                    int src = sc.nextInt();
                    System.out.print("Enter destination vertex: ");
                    int dest = sc.nextInt();
                    graph.addEdge(src, dest);
                    break;

                case 2:
                    // Display the adjacency list
                    graph.displayGraph();
                    break;

                case 3:
                    // Perform BFS traversal
                    System.out.print("Enter starting vertex for BFS traversal: ");
                    int startVertex = sc.nextInt();
                    graph.BFS(startVertex);
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please choose between 1 and 4.");
            }
        }
    }
}

