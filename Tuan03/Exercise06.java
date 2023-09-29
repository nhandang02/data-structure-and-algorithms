public class Exercise06 {
    //a
    public static int findMin(int[] arr) {
        int min = arr[0]; 
    
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i]; 
            }
        }
        return min;
    }

    //b
    public static int sumAllElement(int[] arr) {
        int result = 0; 
        for(int element : arr)  result += element;
        return result;
    }

    //c
    public static int countEvenNum(int[] arr) {
        int count = 0;
        for(int element : arr) {
            if(element % 2 == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 0, 4};
        System.out.println(findMin(a));
        System.out.println(sumAllElement(a));
        System.out.println(countEvenNum(a));
    }
}
