import java.io.File;
import java.util.Scanner;

public class Exercise01_04_05 {

    public static void main(String[] args) throws Exception {

        File file = new File("Exercise01.txt");
        Scanner sc = new Scanner(file);

        int V = sc.nextInt();
        AdjacencyMatrix graph = new AdjacencyMatrix(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph.setEgde(i, j, sc.nextInt());
            }
        }

        sc.close();

        System.out.println();
        System.out.println("----------Exercise01-------------");
        // Print the graph
        graph.printGraph();

        // Count vertices
        System.out.println("Number of vertices: " + graph.countVertices());

        // Count edges
        System.out.println("Number of edges: " + graph.countEdges());

        // Enumerate neighbors of a vertex 3
        System.out.print("Enumerate neighbors of a vertex 3: ");
        graph.neighbors(3);

        // Check the existence of edge (3, 4)
        System.out.println("Check the existence of edge (3, 4) ? : " + graph.hasEdge(3, 3));

        System.out.println();
        System.out.println("----------Exercise04-------------");
        // Exercise 4a - BFS
        System.out.print("BFS : ");
        graph.BFS(3);
        System.out.println();

        // Exercise 4b - DFS
        System.out.print("DFS : ");
        graph.DFS(0);
        System.out.println();

        // Exercise 4c - Stack DFS
        System.out.print("DFS using Stack : ");
        graph.StackDFS(0);
        System.out.println();

        // Exercise 4d - IsReachable
        System.out.println("vertex 4 is reachable from vertex 0 : " + graph.isReachable(4, 0));
        System.out.println("vertex 4 is reachable from vertex 2 : " + graph.isReachable(4, 2));

        System.out.println();
        System.out.println("----------Exercise05-------------");
        //Exercise 5 - Convert AdjacencyMatrix to Adjacency List
        System.out.println("After convert to Adjacency List");
        graph.convertToAL().printGraph();
    }
}