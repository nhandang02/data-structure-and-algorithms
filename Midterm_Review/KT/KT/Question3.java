public class Question3 {
    public static int sumEvenDigits(int n) {
        n = Math.abs(n);
        if (n == 0) return 0;
        if (n % 2 == 0) return (n%10) + sumEvenDigits(n/10);
        return sumEvenDigits(n/10);
    }

    public static void main(String[] args) {
        System.out.println(sumEvenDigits(123456));   
    }
}