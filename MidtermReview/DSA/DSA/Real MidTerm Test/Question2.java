public class Question2 {
    public static int maxLargestDigit(int n) {
        n = Math.abs(n);
        if(n > 0) {
            int digit = n % 10;
            int max = maxLargestDigit(n / 10);
            return Math.max(digit, max);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int n = 12534;
        System.out.print(maxLargestDigit(n));
    }
}