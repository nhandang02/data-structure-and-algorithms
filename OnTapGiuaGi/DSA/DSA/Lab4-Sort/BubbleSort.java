// Bubble Sort algorithm
public class BubbleSort {

	public static void bubbleSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			printArray(a);
		}
	}

	public static void bbubbleSort(int[] a) {
		for(int i = a.length; i >= 0; i--) {
			boolean flag = true;
			for(int j = 0; j < a.length - 1; j++) {
				if(a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					flag = false;
				}
			}
			if(flag) return;
			printArray(a);
		}
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 2, 6, 1};

		// printArray(arr);
		bbubbleSort(arr);
		// printArray(arr);
	}
}

