public class MergeSort {
    private static void merge(int arr[], int l, int m, int r){
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        int L[] = new int [n1];
        int R[] = new int [n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        /* Merge the temp arrays */
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;
        // Initial index of merged sub-array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int first , int last) {
        if (first < last) {
            // Find the middle point
            int middle = (first + last)/2;
            // Sort first and second halves
            mergeSort(arr, first , middle);
            mergeSort(arr, middle + 1, last);
            // Merge the sorted halves
            merge(arr, first , middle , last);
        }
    }

    public static void print(int a[]) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 5, 2, 0, 3, 4};
        mergeSort(a, 0, 5);
        print(a);
    }
}
