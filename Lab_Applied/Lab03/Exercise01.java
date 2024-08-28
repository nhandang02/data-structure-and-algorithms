public class Exercise01 {
    //a
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    //b
    public static int exponential(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= x;
        }
        return result;
    }
    
    //c
    public static int countDigit(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }
    
    //d
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    //e
    public static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    

    public static void main(String[] args) {
        System.out.println("a) " + "factorial(5) = " + factorial(5));
        System.out.println("b) " + "exponential(2, 2) = " + exponential(2,5));
        System.out.println("c) " + "countDigit(1234) = " + countDigit(1234));
        System.out.println("d) " + "isPrime(15) = " + isPrime(15));
        System.out.println("e) " + "GCD(3, 9) = " + GCD(3, 9));
    }
}
