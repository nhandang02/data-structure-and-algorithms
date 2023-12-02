public class SelectionSort {
    public static void SelectionSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx])
                    min_idx = j;
            }
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int a[] = { 1, 5, 2, 0, 3, 4 };
        SelectionSort(a);
        print(a);
    }
}