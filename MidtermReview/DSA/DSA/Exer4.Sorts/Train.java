public class Train {

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1]= temp;
                }
            }
            print(arr);
        }
    }

    public static void bubbleSortLR(int[] a) {
        for(int i = 1; i < a.length; i++) {
            boolean flag = true;
            for(int j = 0; j < a.length - i; j++) {
                if(a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }   
            if(flag) return;
            print(a);
        }
    }

    public static void bubbleSortRL(int[] a) {
        for(int i = a.length - 1; i > 0; i--) {
            boolean flag = true;
            for(int j = 0; j < i; j++) {
                if(a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag = false;
                }
            }
            if(flag) return;
            print(a);
        }
    }

    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void insertLR(int[] a) {
        for(int i = 1; i < a.length; i++) {
            int j, next = a[i];
            for(j = i - 1; j >= 0 && a[j] > next; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = next;
            print(a);
        }
    }

    public static void insertRL(int[] a) {
        for(int i = a.length - 2; i >= 0; i--) {
            int j, next = a[i];
            for(j = i + 1; j <= a.length - 1 && a[j] < next; j++) {
                a[j - 1] = a[j];
            }
            a[j - 1] = next;
            print(a);
        }
    }

    public static void selectLR(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            int index = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[index]) {
                    index = j;
                }
            }
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
            print(a);
        }
    }

    public static void selectRl(int[] a) {
        for(int i = a.length - 1; i >= 0; i--) {
            int index = i;
            for(int j = 0; j < i; j++) {
                if(a[j] > a[index]) {
                    index = j;
                }

                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
                print(a);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 6, 4, 3};

        // print(arr);

        // bubbleSort(arr);
        // bubbleSortLR(arr);
        // bubbleSortRL(arr);

        // insertLR(arr);
        // insertRL(arr);

        // selectLR(arr);
        // selectRl(arr);
    }
}