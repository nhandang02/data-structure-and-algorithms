import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class KruskalMST {
    static class UnionFind {
        private Vector<Integer> p, rank, setSize;

        public UnionFind(int N) {
            p = new Vector<Integer>(N);
            rank = new Vector<Integer>(N);
            setSize = new Vector<Integer>(N);
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i)
                return i;
            else {
                int ret = findSet(p.get(i));
                p.set(i, ret);
                return ret;
            }
        }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                int x = findSet(i), y = findSet(j);
                if (rank.get(x) > rank.get(y)) {
                    p.set(y, x);
                    setSize.set(x, setSize.get(x) + setSize.get(y));
                } else {
                    p.set(x, y);
                    setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y))
                        rank.set(y, rank.get(y) + 1);
                }
            }
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    static class Graph {
        int V;
        int E;
        ArrayList<Edge> edge;

        Graph(int v) {
            V = v;
            edge = new ArrayList<>();
        }

        void addEdge(int src, int dest, int weight) {
            Edge e = new Edge();
            e.src = src;
            e.dest = dest;
            e.weight = weight;
            edge.add(e);
            E++;
        }
    }

    static void kruskalMST(Graph graph) {
        Edge[] result = new Edge[graph.V];
        int e = 0;

        // Sort edges
        Collections.sort(graph.edge);

        UnionFind uf = new UnionFind(graph.V);

        for (Edge nextEdge : graph.edge) {
            // MST logic

            int x = uf.findSet(nextEdge.src);
            int y = uf.findSet(nextEdge.dest);

            if (!uf.isSameSet(x, y)) {
                result[e++] = nextEdge;
                uf.unionSet(x, y);
            }
        }

        // Print MST
        System.out.println("MST Edges");
        for (int i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest);
    }

    // Read Graph File
    public static Graph readGraph(String file) {
        try {
            File graphFile = new File(file);
            Scanner sc = new Scanner(graphFile);

            int V = sc.nextInt();
            Graph graph = new Graph(V);

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph.addEdge(i, j, sc.nextInt());
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

    public static void main(String[] args) {

        int V = 6;
        Graph graph1 = new Graph(V);

        graph1.addEdge(0, 1, 4);
        graph1.addEdge(0, 2, 3);
        // Add remaining edges

        kruskalMST(graph1);

        Graph graph2 = readGraph("graph.txt");

        kruskalMST(graph2);
    }
}
