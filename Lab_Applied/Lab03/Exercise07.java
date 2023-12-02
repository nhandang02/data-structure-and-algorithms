public class Exercise07 {
    //a
    public static int findMinRecursive(int[] arr, int n) {
        if (n == 1) return arr[0];

        return Math.min(arr[n - 1], findMinRecursive(arr, n - 1));    
    }
    
    //b
    public static int sumAllElement(int[] arr, int n) {
        if (n == 1) return arr[0];

        return arr[n - 1] + sumAllElement(arr, n - 1);
    }

    //c
    public static int countEvenNumRecursive(int[] arr, int n) {
        if (n == 0) return 0;
    
        if (arr[n-1] % 2 == 0)    return 1 + countEvenNumRecursive(arr, n - 1);
        
        return countEvenNumRecursive(arr, n - 1);
    }   

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 0 ,4};

        System.out.println("Minimum element in the array: " + findMinRecursive(arr, arr.length));

        System.out.println("Sum all element in the array: " + sumAllElement(arr, arr.length));

        System.out.println("Number of even numbers in the array: " + countEvenNumRecursive(arr, arr.length));
    }
}

