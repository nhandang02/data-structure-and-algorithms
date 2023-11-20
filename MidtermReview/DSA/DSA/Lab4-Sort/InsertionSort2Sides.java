// Insertion Sort algorithm
public class InsertionSort2Sides {

	public static void insertionSortLR(int[] a) {
		for (int i=1; i<a.length; i++) {
			int next = a[i];
			int j;
			for (j=i-1; j>=0 && a[j]>next; j--)
				a[j+1] = a[j];

			a[j+1] = next;
		}
	}

	public static void insertLR(int[] a) {
		for(int i = a.length - 2; i >= 0; i--) {
			int j, next = a[i];
			for(j = i + 1; j < a.length - 1 && a[j] < next; j++) {
				a[j - 1] = a[j];
			}
			a[j - 1] = next;
			printArray(a);
		}
	}

	public static void insertionSortRL(int[] a) {
		//Complete the code here from right to left
		for(int i = a.length - 2 ; i >= 0; i--) {
			int j, next = a[i];
			for(j = i + 1; j < a.length - 1 && a[j] < next; j++) {
				a[j - 1] = a[j];
			}
			a[j - 1] = next;
			printArray(a);
		}
	}
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {5, 1, 2, 6, 4, 3};

		insertLR(arr);
		// insertRL(arr);



		// printArray(arr);
		//insertionSortLR(arr);
		// insertionSortRL(arr);
		// printArray(arr);
	}
}

