public class InsertSort {
    public static void InsertSort(int a[]) {
        int n = a.length;
        for(int i=1; i<n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j>=0 && a[j]>key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }

    public static void print(int a[]) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 5, 2, 0, 3, 4};
        InsertSort(a);
        print(a);
    }
}
