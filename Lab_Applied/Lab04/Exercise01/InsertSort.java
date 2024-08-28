public class InsertSort {
    public static void ISort(int [] arr) {
        for(int i=1; i<arr.length; i++) {
            int next = arr[i];
            int j;
            for(j=i-1; j>=0 && arr[j] > next; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = next;
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
        ISort(arr);
    }
}
