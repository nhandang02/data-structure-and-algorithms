public class Exercise05 {
    public static int Decimal2Binary(int n) {
        if (n == 0) return 0;
        return (n % 2) + 10*Decimal2Binary(n / 2);
    }
    
    public static void main(String[] args) {
        int decimalNumber = 8;
        System.out.println("Binary representation of " + decimalNumber + " is: " + Decimal2Binary(decimalNumber));
    }
    
}
