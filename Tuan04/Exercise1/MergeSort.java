public class MergeSort {
    public static void MSort(int[] arr) {
		mergeSort(arr, 0, arr.length-1);
        print(arr);
	}

	private static void mergeSort(int[] arr, int i, int j) {
		if (i < j) {
			int mid= (i+j)/2;
			mergeSort(arr, i, mid);
			mergeSort(arr, mid+1, j);
			merge(arr, i, mid, j);
		}
	}

	private static void merge(int[] arr, int i, int mid, int j) {
		int[] temp = new int[j-i+1];
		int left = i, right = mid+1, it = 0;

		while (left<= mid && right<=j) {
			if (arr[left] <= arr[right])
				temp[it++] = arr[left++];
			else
				temp[it++] = arr[right++];
		}

		while (left<=mid) temp[it++] = arr[left++];
		while (right<=j)  temp[it++] = arr[right++];

		for (int k = 0; k < temp.length; k++)
			arr[i+k] = temp[k];
	}

	public static void print(int [] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 0, 3, 4};
        MSort(arr);
    }

}
