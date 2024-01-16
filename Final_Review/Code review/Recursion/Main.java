public class Main {
    // Cau1
    public static void printBinary(int n) {
        if (n > 0) {
            printBinary(n/2);
            System.out.print(n%2 + "");
        }
    }

    // Cau2
    public static int reverse(int n) {
        if (n < 10) return n;
        int lastDigit = n % 10;
        return lastDigit * (int)Math.pow(10, numbersOfDigit(n) - 1) + reverse(n/10);
    }
    public static int numbersOfDigit(int n) {
        if (n < 10) return 1;
        return 1 + numbersOfDigit(n/10);
    }

    // Cau3
    public static int count(String str, char c, int index) {
        str = str.toLowerCase();
        if (index >= str.length()) {
            return 0;
        }
        int count = 0 ;

        if (str.charAt(index) == c ) {
            count++;
        }

        count += count(str, c, index+1);

        return count;
    }

    public static String decimalToHexa(int n) {
        if (n == 0) return "";
        int remainder = n % 16;
        String hexChar = hexChar(remainder);
        return decimalToHexa(n/16) + hexChar;
    }
    public static String hexChar(int n) {
        if (n >=0 && n<=9) {
            return String.valueOf(n);
        }
        
        char c = (char) (n + 55); 

        return String.valueOf(c);
    }

    //Cau5
    public static void print(int a[], int index) {
        if (index >= a.length) return;
        System.out.print(a[index] + " ");
        print(a, index*2);
    }

    //Cau6
    public static void printEven(int n) {
        if (n == 0) {
            return;
        }
        if ( (n%10) % 2 == 0 ) {
            System.out.print(n%10 + " ");
        }
        printEven(n/10);
    }

    // public static int countVowel(String str) {
    //     str = str.toLowerCase();

    //     if (str.length() == 0) return 0;

    //     String Vowel = "ueoai";
    //     int count = 0;
    //     if (Vowel.indexOf(str.charAt(0)) != -1) {
    //         count = 1;
    //     }

    //     return count + countVowel(str.substring(1));
    // }

    public static int countVowel(String str) {
        str = str.toLowerCase();
        if (str.length() == 0) return 0;
        int count = 0;
        String vowel = "ueoai";
        if (vowel.indexOf(str.charAt(0)) != -1) {
            count = 1;
        }
        return count + countVowel(str.substring(1));
    }

    private static int findMax(int a[], int n, int max) {
        if (n == a.length-1) return n;
        if (sum(a[n]) == max) return n;
        return findMax(a, n+1, max);
    }
    public static int findMax(int a[], int n){
        return findMax(a, n, findMaxElement(a, 0));
    }


    public static int sum(int n) {
        if (n<10) return n;
        return n%10 + sum(n/10);
    }
    public static int findMaxElement(int a[], int n) {
        if (n == a.length-1) return sum(a[n]);
        return (int) Math.max( sum(a[n]), findMaxElement(a, n+1) );
    }

    public static void main(String[] args) {
        //printBinary(10);
        //System.out.println(reverse(12345));
        //System.out.println(count("Dang Thanh Nhan", 'n', 0));
        //System.out.println(decimalToHexa(345));
        int a[] = {1, 222222222, 33, 4, 555, 1529};
        //print(a, 1);
        //printEven(123456);
        //System.out.println(countVowel("DOeang Thanh Nhan"));

        System.out.println(findMax(a, 0));

        System.out.println(findMaxElement(a, 0));
    }
}