import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyMatrix {
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public AdjacencyMatrix(int vertices) {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public void setEgde(int vertexSource, int vertexDestination,
            int weight) {
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
    }

    // Check existances
    public int getEgde(int vertexSource, int vertexDestination) {
        try {
            return adj[vertexSource][vertexDestination];
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    // Count vertices
    public int countVertices() {
        return NUMBER_OF_VERTICES;
    }

    // Count edges
    public int countEdges() {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if (adj[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    // Enumerate neighbors of vertex u
    public void neighbors(int u) {
        for (int v = 0; v < NUMBER_OF_VERTICES; v++) {
            if (adj[u][v] != 0) {
                System.out.print(v + " ");
            }
        }
        System.out.println();
    }

    public void printGraph() {
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Check the existence of edge (u, v)
    public boolean hasEdge(int u, int v) {
        if (adj[u][v] != 0)
            return true;
        return false;
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            System.out.print(x + " ");

            for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if (adj[x][i] != 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS_recur(int v, boolean[] visited) {
        visited[v] = true;

        System.out.print(v + " ");

        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if (adj[v][i] != 0 && visited[i] == false) {
                DFS_recur(i, visited);
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recur(s, visited);
    }

    public void StackDFS(int startV) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];
        Stack<Integer> stack = new Stack<>();
        stack.push(startV);
        while (!stack.isEmpty()) {
            int currV = stack.pop();
            if (!visited[currV]) {
                System.out.print(currV + " ");
                visited[currV] = true;
            }

            for (int i = NUMBER_OF_VERTICES - 1; i >= 0; i--) {
                if (adj[currV][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public boolean isReachable(int u, int v) {
        if (adj[u][v] == 1)
            return true;
        return false;
    }

    public AdjacencyList convertToAL() {
        AdjacencyList adjacencyList = new AdjacencyList(NUMBER_OF_VERTICES);
        for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
                if (adj[i][j] == 1) {
                    adjacencyList.addEdge(i, j);
                }
            }
        }
        return adjacencyList;
    }
}
