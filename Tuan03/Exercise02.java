public class Exercise02 {
    //a
    public static int factorial(int n) {
        if(n==0 || n==1)  return 1;
        return n * factorial(n-1);
    }

    //b
    public static int exponential(int x, int y) {
        if(y==0) return 1;
        return x * exponential(x, y-1);
    }

    //c
    public static int countNum(int n) {
        if(n < 10) return 1;
        return 1 + countNum(n/10);
    }

    //d
    public static int GCD(int a, int b) {
        if(b == 0) return a;
        return GCD(b, a % b);
    }



    public static void main(String[] args) {
        System.out.println("a) " + "facturial(5) = " + factorial(5));
        System.out.println("b) " + "exponential(2, 2) = " + exponential(2,5));
        System.out.println("c) " + "countNum(1234) = " + countNum(1234));
        System.out.println("d) " + "GCD(3, 9) = " + GCD(3, 9));
    }
}