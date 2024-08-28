import java.io.File;
import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) throws Exception {

        File file = new File("Exercise02.txt");
        Scanner sc = new Scanner(file);

        // Lấy số đỉnh V
        int V = Integer.parseInt(sc.nextLine());

        // Tạo đối tượng AdjacencyList
        AdjacencyList graph = new AdjacencyList(V);

        // Đọc các cạnh và thêm vào đối tượng
        while (sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            for (int i = 1; i < parts.length; i++) {
                int v = Integer.parseInt(parts[i]);
                graph.addEdge(u, v);
            }
        }
        sc.close();

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
        System.out.print("Check the existence of edge (3, 4) ? : " + graph.hasEdge(3, 4));
    }
}
