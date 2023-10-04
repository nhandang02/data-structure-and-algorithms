public class QuickSort {
    public static void QSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
        print(arr);
	}

	private static void quickSort(int[] arr, int i, int j) {
		if (i < j) {
			int pivotIdx= partition(arr, i, j);
			quickSort(arr, i, pivotIdx-1);
			quickSort(arr, pivotIdx+1, j);
		}
	}

	private static void swap(int[] arr, int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	private static int partition(int[] arr, int i, int j) {
                                 
		int p = arr[i];   
		int m = i;  

		for (int k=i+1; k<=j; k++) { 
			if (arr[k] < p) { 
				m++;
				swap(arr,k,m);
			}
		}

		swap(arr,i,m); 
		return m;   
	}

    public static void print(int [] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 0, 3, 4};
        QSort(arr);
    }
}
