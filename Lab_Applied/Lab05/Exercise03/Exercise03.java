public class Exercise03 {
    // a iteration
    public static double Qa_iteration(int n) {
        double result = 0;
        for (int i = 0; i <= n; i++) {
            result = 2 - result / 2.0;
        }
        return result;
    }

    // a recursion
    public static double Qa_recursion(int n) {
        if (n == 0)
            return 2;
        return 2 - 1 / 2.0 * Qa_recursion(n - 1);
    }

    // b iteration
    public static double Qb_iteration(int n) {
        double result = 1;
        while (n >= 10) {
            result += 1;
            n = n / 10;
        }
        return result;
    }

    // b recursion
    public static double Qb_recursion(int n) {
        if (n < 10)
            return 1;
        return n + Qb_recursion(n / 10);
    }

    // c iteration
    public static int Qc_iteration(int n, int k) {
        int result = 0;
        for (int i = 1; i <= k; i++)
            result += n;
        return result;
    }

    // c recursion
    public static int Qc_recursion(int n, int k) {
        if (k == 1)
            return n;
        return n + Qc_recursion(n, k - 1);
    }

    // d iteration
    public static int Qd_iteration(int n) {
        if (n <= 2)
            return 1;
        else {
            int prev1 = 1, prev2 = 1, curr = 0;
            for (int i = 3; i <= n; i++) {
                curr = prev1 + prev2;
                prev2 = prev1;
                prev1 = curr;
            }
            return curr;
        }

    }

    public static int Qd_recursion(int n) {
        if (n == 0 || n == 1) return n;
        return Qd_recursion(n-1) + Qd_recursion(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Qa_iteration(0));
        System.out.println(Qa_recursion(0));
        System.out.println();
        System.out.println(Qb_iteration(0));
        System.out.println(Qb_recursion(0));
        System.out.println();
        System.out.println(Qc_iteration(3, 2));
        System.out.println(Qc_recursion(3, 2));
        System.out.println();
        System.out.println(Qd_iteration(4));
        System.out.println(Qd_recursion(4));
    }
}