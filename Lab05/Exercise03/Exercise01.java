public class Exercise01 {
    public static double pro_recur(int a, int b) {
        if (b == 0) return 0;
        return a + pro_recur(a, b - 1);
    }

    public static int bin2dec(int n, int exp) {
        if (n == 0) return 0;
        return (n % 10) * (int)Math.pow(2, exp) + bin2dec(n/10, exp+1);
    }

    public static int maxDigit(int n) {
        if (n < 10) return n;
        return Math.max(n % 10, maxDigit(n/10));
    }

    public static int maxElement(int a[], int n) {
        if (n == 1) return a[0];
        return Math.max(a[n-1], maxElement(a, n-1));
    }
    public static int search(int a[], int n, int key) {
        if (n == 0) return -1;
        if (a[n-1] == key) return n-1; 
        return search(a, n-1, key);
      }

    public static void main(String[] args) {
        System.out.println(pro_recur(2, 10));
        System.out.println(bin2dec(1000, 0));
        System.out.println(maxDigit(12534));
        int a[] = {0, 1, 200, 3, 4, 5};
        System.out.println(maxElement(a, 6));
        System.out.println(search(a, 6, 200));
    }
}