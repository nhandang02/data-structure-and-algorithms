import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    // No. of vertices in the graph
    private static final int V = 5;

    // Function to find the vertex with minimum key value, from
    // the set of vertices not yet included in MST
    public static int minKey(int[] key, Boolean[] mstSet) {
        int min = INF, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // Function to construct and print MST using Prim's algorithm
    public static void primMST(int[][] graph) {
        int[] parent = new int[V];
        int[] key = new int[V];
        Boolean[] mstSet = new Boolean[V];

        // Initialize all keys as INFINITE and mstSet[] as false
        for (int i = 0; i < V; i++) {
            key[i] = INF;
            mstSet[i] = false;
        }

        // Always include first vertex in MST.
        key[0] = 0;
        parent[0] = -1; // First node is root of MST

        // The MST will have V-1 edges
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);

            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent vertices of
            // the picked vertex. Consider only those vertices which are not yet
            // included in MST
            for (int v = 0; v < V; v++) {
                // graph[u][v] is non-zero only for adjacent vertices
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // print MST
        printMST(parent, graph);
    }

    // Read Graph File
    public static int[][] readGraph(String file) {
        try {
            File graphFile = new File(file);
            Scanner sc = new Scanner(graphFile);

            int V = sc.nextInt();
            int[][] graph = new int[V][V];

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            sc.close();
            return graph;

        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file " + file);
            return null;

        } catch (InputMismatchException e) {
            System.out.println("Input format error while reading graph file");
            return null;

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        }
    }

    public static void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \t Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int[][] graph1 = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        primMST(graph1);

        int[][] graph2 = readGraph("graph.txt");

        primMST(graph2);
    }
}