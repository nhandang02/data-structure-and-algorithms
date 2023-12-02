import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    private Node insert(Node x, Integer key) {
        if (x == null)
            return new Node(key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key);
        else if (cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;
        return x;
    }

    public Node insert(Integer key) {
        root = insert(root, key);
        return root;
    }

    public void NLR() {
        NLR(root);
    }
    public void NLR(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void LNR() {
        LNR(root);
    }
    public void LNR(Node x) {
        // code here
        if (x != null) {
            LNR(x.left);
            System.out.print(x.key + " ");
            LNR(x.right);
        }
    }

    public void LRN() {
        LRN(root);
    }
    public void LRN(Node x) {
        // code here
        if (x != null) {
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.key + " ");
        }
    }

    private Node search(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left , key);
        else if (cmp > 0)
            return search(x.right , key);
        else
            return x;
    }

    public Node search(Integer key) {
        return search(root, key);
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Node min() {
        return min(root);
    }

    private Node max(Node x) {
        // code here
        if (x.right == null)
            return x;
        else
            return max(x.right);

    }

    public Node max() {
        return max(root);
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

    private Node delete(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            // node with only one child or no child
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            // node with two children: Get the successor (smallest in
            // the right subtree)
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }
        return x;
    }

    public Node delete(Integer key) {
        return delete(root, key);
    }

    //Exercise02
    public void createTree(String strKey) {
        String[] strk = strKey.split(" ");
        for (String str : strk) {
            Integer i = Integer.parseInt(str);
            insert(i);
        }
    }

    //Exercise03
    private void printDescending(Node x) {
        if (x == null) {
            return;
        }

        printDescending(x.right);

        System.out.print(x.key + " ");

        printDescending(x.left);
    }

    public void printDescending() {
        printDescending(root);
    }

    //Exercise04
    private boolean contains(Node x, Integer key) {
        if (x == null) {
            return false;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return contains(x.left, key);
        } else if (cmp > 0) {
            return contains(x.right, key);
        } else {
            return true;
        }
    }

    public boolean contains(Integer key) {
        // your code here
        return contains(root, key);
    }

    //Exercise05
    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        return x;
    }

    public void deleteMax() {
        // your code here
        deleteMax(root);
    }

    //Exercise06
    private Node delete_pre(Node x, Integer key) {
        if (x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete_pre(x.left, key);
        else if (cmp > 0)
            x.right = delete_pre(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;

            x.key = max(x.left).key;
            x.left = deleteMax(x.left);
        }
        return x;
    }

    public void delete_pre(Integer key) {
        // your code here
        root = delete_pre(root, key);
    }

    ////Exercise07
    private int height(Node x) {
        if (x == null)
            return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public int height() {
        // your code here
        return height(root);
    }


    //Exercise08
    private Integer sum(Node x) {
        if (x == null) {
            return 0;
        }

        return x.key + sum(x.left) + sum(x.right);
    }

    public Integer sum() {
        // your code here
        return sum(root);
    }


    //Exercise09
    private Integer sumEven(Node x) {
        if (x == null) {
            return 0;
        }
        if (x.key % 2 == 0)
            return x.key + sumEven(x.left) + sumEven(x.right);
        return sumEven(x.left) + sumEven(x.right);
    }

    public Integer sumEven() {
        // your code here
        return sumEven(root);
    }


    //Exercise10
    private int countLeaves(Node x) {
        if (x == null) {
            return -1;
        }

        if (x.left == null && x.right == null) {
            return 1;
        }

        return countLeaves(x.left) + countLeaves(x.right);
    }

    public int countLeaves() {
        // your code here
        return countLeaves(root);
    }


    //Exercise11
    private int sumEvenKeysAtLeaves(Node x) {
        if (x == null) {
            return 0;
        }

        if (x.left == null && x.right == null) {
            if (x.key % 2 == 0) {
                return x.key;
            } else {
                return 0;
            }
        }

        return sumEvenKeysAtLeaves(x.left) + sumEvenKeysAtLeaves(x.right);
    }

    public int sumEvenKeysAtLeaves() {
        // your code here
        return sumEvenKeysAtLeaves(root);
    }


    //Exercise12
    private void bfs(Node x) {
        if (x == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.key + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public void bfs() {
        // your code here
        bfs(root);
    }
}

