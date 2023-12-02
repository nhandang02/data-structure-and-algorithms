public class Exercise04 {
    // public static void SelectionSort(int a[]) {
    //     for (int i = 0; i < a.length; i++) {
    //         int min_Index = i;
    //         for (int j = i + 1; j < a.length; j++) {
    //             if (a[j] < a[min_Index]) {
    //                 min_Index = j;
    //             }
    //         }
    //         int temp = a[min_Index];
    //         a[min_Index] = a[i];
    //         a[i] = temp;
    //         print(a);
    //     }
    // }

    // public static void BubbleSort(int a[]) {
    //     int n = a.length;
    //     for (int i = 0; i < n - 1; i++) {
    //         for (int j = 0; j < n - i - 1; j++) {
    //             if (a[j] > a[j + 1]) {
    //                 int temp = a[j];
    //                 a[j] = a[j + 1];
    //                 a[j + 1] = temp;
    //                 print(a);
    //             }
    //         }
    //     }
    // }
    // public static void InsertSort(int a[]) {
    //     int n = a.length;
    //     for(int i=1; i<n; i++) {
    //         int key = a[i];
    //         int j = i - 1;
    //         while (j>=0 && a[j]>key) {
    //             a[j+1] = a[j];
    //             j--;
    //         }
    //         a[j+1] = key;
    //         print(a);
    //     }
    // }


    public static void print(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

   public static void SelectionSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min_Index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_Index]) {
                    min_Index = j;
                }
            }
            int temp = a[min_Index];
            a[min_Index] = a[i];
            a[i] = temp;
            print(a);
        }
   }

   public static void BubbleSort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1 ; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    print(a);
                }
            }
        }
   }


    public static void InsertSort(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
            print(a);
        }
    }
    public static void main(String[] args) {
        // int a[] = {14, 33, 27, 10, 35, 19, 42, 44};
        // SelectionSort(a);
        // System.out.println();
        // int b[] = {5, 1, 4, 2, 8};
        // BubbleSort(b);
        // System.out.println();
        int c[] = {4, 3, 2, 10, 12, 1, 5, 6};
        InsertSort(c);
        System.out.println();
    }
}
