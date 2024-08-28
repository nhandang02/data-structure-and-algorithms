public class Test {
    public static void main (String[] args) {
        MyQueue queue = new MyQueue();
        
        queue.Enqueue(new Fraction(1, 2));
        queue.Enqueue(new Fraction(3, 4));
        queue.Enqueue(new Fraction(5, 6));
        // queue.print();
        System.out.println();

        System.out.println(queue.contains(new Fraction(1, 2)));
        System.out.println();

        // System.out.println(queue.getFront());
        // queue.print();

        System.out.println(queue.Dequeue());
        queue.print();
        System.out.println();
        System.out.println(queue.Dequeue());
        queue.print();
        System.out.println();
        System.out.println(queue.Dequeue());
        queue.print();
        System.out.println();

        System.out.println(queue.isEmpty());
    }
}