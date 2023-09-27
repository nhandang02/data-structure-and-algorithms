public class Test {
   public static void main(String[] args) {
        QueueWith2Stack<Integer> queue = new QueueWith2Stack<>();

        queue.Enqueue(1);
        queue.Enqueue(2);
        queue.Enqueue(3);
        System.out.println();

        System.out.println("Dequeue: " + queue.Dequeue()); // Should print 1
        System.out.println("Dequeue: " + queue.Dequeue()); // Should print 2

        queue.Enqueue(4);
        System.out.println("Size: " + queue.size()); // Should print 2

        System.out.println("Dequeue: " + queue.Dequeue()); // Should print 3
        System.out.println("Dequeue: " + queue.Dequeue()); // Should print 4
        System.out.println("Size: " + queue.size()); // Should print 0
    }
}