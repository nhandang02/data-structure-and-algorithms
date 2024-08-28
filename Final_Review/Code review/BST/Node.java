public class Node {
    int key;
    Node left, right;

    public Node() {
        this.key = 0;
        this.left = this.right = null;
    }

    public Node(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}