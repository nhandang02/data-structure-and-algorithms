import java.util.*;
public class Exercise02 {
    //a iteration
    public static int Qa_iteration(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += Math.pow(2, i);
        }
        return result;
    }
    //a recursion
    public static int Qa_recursion(int n) {
        if (n == 1) return 2;
        return (int)Math.pow(2, n) + Qa_recursion(n-1);
    }

    //b iteration
    public static double Qb_iteration(int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result += (i+1)/2.0;
        }
        return result;
    }
    public static double Qb_recursion(int n) {
        if (n == 0) return 1/2.0;
        return (n+1)/2.0 + Qb_recursion(n-1);
    }

    //c 
    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }
    // c iteration 
    public static double Qc_iteration(int n) {
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result += factorial(i)*1.0 / factorial(i-1); 
        }
        return result;
    }
    // c recursion
    public static double Qc_recursion(int n) {
        if (n == 1) return 1;
        return factorial(n)*1.0 / factorial(n-1) + Qc_recursion(n-1);
    }

    //d iteration
    public static int Qd_iteration(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i*(i-1);
        }
        return result;
    }
    // d recursion
    public static int Qd_recursion(int n) {
        if (n == 1) return 0;
        return n*(n-1) + Qd_recursion(n-1);
    }

    // e iteration
    public static int Qe_iteration(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    // e recursion
    public static int Qe_recursion(int n) {
        if (n == 1) return 1;
        return n * Qe_recursion(n-1);
    }

    public static void main(String[] args) {
        System.out.println(Qa_iteration(3));
        System.out.println(Qa_recursion(3));
        System.out.println();
        System.out.println(Qb_iteration(3));
        System.out.println(Qb_recursion(3));
        System.out.println();
        System.out.println(Qc_iteration(3));
        System.out.println(Qc_recursion(3));
        System.out.println();
        System.out.println(Qd_iteration(3));
        System.out.println(Qd_recursion(3));
        System.out.println();
        System.out.println(Qe_iteration(3));
        System.out.println(Qe_recursion(3));
    }
}
