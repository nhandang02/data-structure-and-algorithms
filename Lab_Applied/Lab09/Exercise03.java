public class Exercise03 {
    public static void main(String args[]) {
        EdgeList graph = new EdgeList();
        // a
        graph.readGraphFromFile("Exercise03.txt");
        System.out.println("Graph:");
        graph.printGraph();
        // b
        System.out.println("The number of vertices :" + graph.numVer());
        // c
        System.out.println("The number of edges : " + graph.numEdges());
        // d
        graph.enumirate(3);
        // e
        System.out.println("Check the existence of edge (0, 2) : " + graph.checkExis(0, 2));
        System.out.println("Check the existence of edge (1,4) : " + graph.checkExis(1, 4));
        
    }
}
