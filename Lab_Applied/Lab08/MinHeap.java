import java.util.NoSuchElementException;

public class MinHeap {
    int[] heap;
    int heapSize;
    int maxSize;

    public MinHeap(int capity) {
        heapSize = 0;
        this.maxSize = capity + 1;
        heap = new int[maxSize];
        heap[0] = -1;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i*2 + 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (heapSize == maxSize)
            throw new NoSuchElementException("Overflow Exception");

        heapSize += 1;
        heap[heapSize] = key;

        shiftUp(heapSize);
    }

    private void shiftUp(int i) {
        while (i > 1 && heap[parent(i)] > heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public int extractMin() {
        if (heapSize == 0)
            throw new NoSuchElementException("Underflow Exception");

        int min = heap[1];
        heap[1] = heap[heapSize];
        heapSize -= 1;
        shiftDown(1);

        return min;
    }

    private void shiftDown(int i) {
        while (i <= heapSize) {
            int min = heap[i];
            int min_id = i;

            if (left(i) <= heapSize && min > heap[left(i)]) {
                min = heap[left(i)];
                min_id = left(i);
            }

            if (right(i) <= heapSize && min > heap[right(i)]) {
                min = heap[right(i)];
                min_id = right(i);
            }

            if (min_id != i) {
                swap(i, min_id);
                i = min_id;
            } 
            else break;
        }
    }

    public static void heapSort(int[] arr) {
        MinHeap heap = new MinHeap(arr.length);

        for (int i : arr) {
            heap.insert(i);
        }

        for (int i = 0; i < arr.length; i++) { // sort ascending
            arr[i] = heap.extractMin();
        }
        /*for (int i = arr.length - 1; i >= 0; i--) {    // sort descending
          arr[i] = heap.extractMax();
        }*/
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }

    public static void main(String [] args) {
        int[] arr = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39}; 
        heapSort(arr);
        printArr(arr);
    }
}
