public class Test {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(1);
        bst.insert(2);
        bst.insert(-2);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);
        bst.insert(9);
        bst.insert(3);
        bst.insert(-3);

        //          5
        //        /   \
        //       1     7
        //      / \    / \
        //    -2   2  6   8
        //    /     \       \
        //  -3       3       9

        /* //NLR, LRN, LNR
        System.out.print("NLR: ");
        bst.NLR();
        System.out.println();
        System.out.print("LRN: ");
        bst.LRN();
        System.out.println();
        System.out.print("LNR: ");
        bst.LNR();
        System.out.println();

        //Search
        System.out.println();
        System.out.print("Search key (7): ");
        System.out.println(bst.search(7).key);

        //Search MIN
        System.out.println();
        System.out.print("Search MIN: ");
        System.out.println(bst.min().key);
        System.out.println();
        
        //Search MAX
        System.out.println();
        System.out.print("Search MAX: ");
        System.out.println(bst.max().key);
        System.out.println();

        //Delete MIN
        System.out.println("Delete MIN: ");
        bst.deleteMin();
        System.out.print("After delete: ");
        bst.NLR();
        System.out.println();
        System.out.println();

        //Delete KEY "key = min(right)"
        System.out.println();
        System.out.println("Delete key (7): ");
        bst.delete(7);
        System.out.print("After delete key: ");
        bst.NLR();
        System.out.println();

        //Create Tree (Insert String)
        System.out.println();
        System.out.println("Insert to Tree from String values '-2 7 12 24'");
        String str = "-2 7 12 24";
        bst.createTree(str);
        System.out.print("After insert: ");
        bst.NLR();
        System.out.println();

        //Print DESCENDING
        System.out.println();
        System.out.print("Print DESCENDING: ");
        bst.printDescending();
        System.out.println();

        //Contain KEY
        System.out.println();
        System.out.println("Contain Key (7) in tree ?");
        System.out.println(bst.contains(7));

        //Delete MAX
        System.out.println();
        System.out.println("Delete MAX: ");
        bst.deleteMax();
        System.out.print("After delete: ");
        bst.NLR();
        System.out.println();

        //Delete KEY "key = max(left)"
        System.out.println();
        System.out.println("Delete key (6): ");
        bst.delete_pre(6);
        System.out.print("After delete key: ");
        bst.NLR();
        System.out.println();
        */

        //Height
        System.out.println();
        System.out.print("Height of the tree: ");
        System.out.println(bst.height());

        //Sum
        System.out.println();
        System.out.print("Sum all elements of the tree: ");
        System.out.println(bst.sum());
        System.out.println();

        //SumEven
        System.out.println();
        System.out.print("Sum all EVEN elements of the tree: ");
        System.out.println(bst.sumEven());
        System.out.println();

        //CountLeaves
        System.out.println();
        System.out.print("LEAVES of the tree: ");
        System.out.println(bst.countLeaves());
        System.out.println();

        //SumEven Leaves
        System.out.println();
        System.out.print("Sum all EVEN LEAVES elements of the tree: ");
        System.out.println(bst.sumEvenKeysAtLeaves());
        System.out.println();

        //Size Of Tree
        System.out.println();
        System.out.print("Size of tree: ");
        System.out.println(bst.size());
        System.out.println();

        //Count Node One Child
        System.out.println();
        System.out.print("Nodes One Child: ");
        System.out.println(bst.countNodeOneChild());
        System.out.println();

        //Sum Key In Range
        System.out.println();
        System.out.print("sum Key In Range[-2, 7]: ");
        System.out.println(bst.sumKeyInRange(-2, 7));
        System.out.println();

        //Sum Node One Child
        System.out.println();
        System.out.print("Sum All Nodes One Child: ");
        System.out.println(bst.sumOneChildNodes());
        System.out.println();

        //Find Node MAX At Level X
        System.out.println();
        System.out.print("Find Node Max At Level 3: ");
        System.out.println(bst.maxOfLevel(3));
        System.out.println();

        //BFS
        System.out.println();
        System.out.println("BFS: ");
        bst.bfs();
    }
}
