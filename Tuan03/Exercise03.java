public class Exercise03 {
    public static boolean isPrime(int n, int d) {
        if (n < 2) {
            return false;
        }
        
        if (d * d > n) {
            return true;
        }
        
        if (n % d == 0) {
            return false;
        }
        
        return isPrime(n, d + 1);
    }
    
    public static boolean isPrime(int n) {
        return isPrime(n, 2);
    }
    
    public static void main(String[] args) {
        int n = 6;
        System.out.println(n + " is Prime ?: " + isPrime(n));
    }
}
