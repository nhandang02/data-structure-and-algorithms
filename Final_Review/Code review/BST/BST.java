import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    private Node insert(Node x, int key) {
        if (x == null)
            return new Node(key);

        if (key < x.key)
            x.left = insert(x.left, key);
        else if (key > x.key)
            x.right = insert(x.right, key);
        else
            x.key = key;
        return x;
    }
    public Node insert(int key) {
        root = insert(root, key);
        return root;
    }

    private void NLR(Node x) {
        if (x != null) {
            System.out.println(x.key + "");
            NLR(x.left);
            NLR(x.right);
        }
    }
    public void NLR() {
        NLR(root);
    }

    private Node search(Node x, int key) {
        if (x == null) {
            return null;
        }

        if (key > x.key) {
            return search(x.right, key);
        }
        else if (key < x.key) {
            return search(x.left, key);
        }
        else {
            return x;
        }
    }
    public Node search(int key) {
        return search(root, key);
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }
    public Node min() {
        return min(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)     
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }
    public Node deleteMin() {
        return deleteMin(root);
    }

    private Node delete(Node x, int key) {
        if (x == null) {
            return null;
        }
        
        if (key < x.key)
            delete(x.left, key);

        if (key > x.key)
            delete(x.right, key);

        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }
        return x;
    }
    public Node delete(int key) {
        return delete(root, key);
    }
}
