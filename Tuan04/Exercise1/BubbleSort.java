public class BubbleSort {
    public static void BSort(int [] arr) {
        for(int i=1; i<arr.length; i++) {
            for(int j=0; j < i; j++) {
                if(arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp; 
                }
            }
        }
        print(arr);
    }

    public static void print(int [] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 0, 3, 4};
        BSort(arr);
    }
}
