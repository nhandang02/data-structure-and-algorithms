public class RecursiveP {
    public static int computeP(int n) {
        if (n == 1) {
            return 3;
        } else {
            return 2 * n + n * n + computeP(n - 1);
        }
    }
}