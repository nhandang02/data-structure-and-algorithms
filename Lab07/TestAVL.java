class TestAVL
{
    public static void main(String[] arg)
    {
        //String s = "20 10 5 30 40";
        String s = "8 5 2 17 20 10 30 15";

        String[] key = s.split(" ");
        //chuyen sang so nguyen
        Integer[] k = new Integer[key.length];
        for(int i = 0; i<k.length; ++i)
            k[i] = Integer.parseInt(key[i]);
        
        AVL b = new AVL(k[0]);
        for(int i = 1; i<k.length; ++i)
        {
            b.insert(b.root, k[i]);
            b.root = b.balance(b.root);
        }
        b.NLR(b.root);
        System.out.println();
        b.RNL(b.root);
        System.out.println();

        System.out.println("The height of root: " + b.height(b.root));
        System.out.println("Min of the tree: " + b.min());
        System.out.println("Max of the tree: " + b.max());
        //Them
        int  x  = 100;
        b.insert(b.root, x);
        b.root = b.balance(b.root);
        b.NLR(b.root);
        System.out.println(" ");
        System.out.println("The height of root: " + b.height(b.root));
        //xoa
        x = 2;
        b.delete(b.root, x);
        b.NLR(b.root);
        System.out.println();
        System.out.println("The height of root: " + b.height(b.root));
        //sum
        System.out.println("Sum = " + b.sum(b.root));
        //Sum Even
        System.out.println("Sum Even = " + b.sumEven(b.root));
        //count children
        System.out.println("Count Children = " + b.countChild(b.root));
        //Find First Odd
        System.out.println("Find First Odd = " + b.findFirstOdd(b.root));
    }
}