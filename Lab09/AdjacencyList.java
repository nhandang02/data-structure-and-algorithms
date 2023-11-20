import java.util.*;

public class AdjacencyList {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    public AdjacencyList(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for (Integer v : adj[i]) {
                System.out.print("->" + v);
            }
            System.out.println();
        }
    }

    // Count vertices
    public int countVertices() {
        return V;
    }

    // Count edges
    public int countEdges() {
        int count = 0;
        for (int i = 0; i < V; i++) {
          count += adj[i].size();
        }
        return count/2;
    } 
    
    // Enumerate neighbors of vertex u
    public void neighbors(int u) {
        System.out.print("Vertex " + u + ":");
        for (int v : adj[u]) {
          System.out.print(" " + v); 
        }
        System.out.println();
    }

    // Check the existence of edge (u, v)
    public boolean hasEdge(int u, int v) {
        return adj[u].contains(v);
    }
}