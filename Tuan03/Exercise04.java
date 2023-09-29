public class Exercise04 {
    //a
    public static int FuncA(int n) {
        if(n == 1)  return 2 * n + 1;
        return 2 * n + 1 + FuncA(n - 1);
    }

    //b
    public static int factorial(int n) {
        if(n == 0 || n == 1)  return 1;
        return n * factorial(n-1);
    }

    public static int FuncB(int n) {
        if(n == 1) return factorial(n);
        return factorial(n) + FuncB(n-1); 
    }

    //c
    public static int FuncC(int n) {
        if (n == 1) return factorial(n);
        return factorial(n) * FuncC(n-1); 
    }

    //d
    public static int FuncD(int n, int k) {
        if (k == 0 || k == n)   return 1;
        return FuncD(n - 1, k - 1) + FuncD(n - 1, k);
    }

    //e
    public static int FuncE(int n) {
        if (n == 1) return 3;
        return (int) (Math.pow(2, n) + Math.pow(n, 2) + FuncE(n - 1));
    }

    public static void main(String[] args) {
        System.out.println(FuncA(2));
        System.out.println(FuncB(3));
        System.out.println(FuncC(2));
        System.out.println(FuncD(3, 2));
        System.out.println(FuncE(2));
    }
}
