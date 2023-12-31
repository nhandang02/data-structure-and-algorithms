import java.util.NoSuchElementException;

public class PriorityQueue {

    Person[] heap;
    int heapSize;
    int maxSize;

    public PriorityQueue(int capacity) {
        heapSize = 0;
        maxSize = capacity + 1;
        heap = new Person[maxSize];
        heap[0] = null;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    private void swap(int i, int j) {
        Person temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void shiftUp(int i) {
        while (i > 1 && heap[parent(i)].compareTo(heap[i]) < 0) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public void enqueue(Person person) {
        if (heapSize == maxSize - 1) {
            throw new NoSuchElementException("Overflow");
        }
        heapSize++;
        heap[heapSize] = person;
        shiftUp(heapSize);
    }

    public Person dequeue() {
        if (heapSize == 0) {
            throw new NoSuchElementException("Underflow");
        }
        Person max = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int i) {
        int maxIndex = i;
        int l = left(i);
        if (l <= heapSize && heap[l].compareTo(heap[maxIndex]) > 0) {
            maxIndex = l;
        }
        int r = right(i);
        if (r <= heapSize && heap[r].compareTo(heap[maxIndex]) > 0) {
            maxIndex = r;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }

    public void print() {

        for (int i = 1; i <= heapSize; i++) {
            System.out.print(heap[i].name);
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(10);
        PriorityQueue queue_Deleted = new PriorityQueue(10);

        queue.enqueue(new Person("Alex", 3));
        queue.enqueue(new Person("Bob", 2));
        queue.enqueue(new Person("David", 6));
        queue.enqueue(new Person("Susan", 1));

        queue.print();

        queue_Deleted.enqueue(queue.dequeue()); 

        queue.enqueue(new Person("Mike", 5));
        queue.enqueue(new Person("Kevin", 4));

        queue_Deleted.enqueue(queue.dequeue()); 
        queue_Deleted.enqueue(queue.dequeue());  

        queue.enqueue(new Person("Helen", 0));
        queue.enqueue(new Person("Paul", 8));
        queue.enqueue(new Person("Iris", 7));

        queue_Deleted.enqueue(queue.dequeue()); 

        queue_Deleted.print();

    }
}