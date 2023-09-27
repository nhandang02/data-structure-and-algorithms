import java.util.Stack;
import java.util.Queue;
public class QueueWith2Stack<E> {
    Stack<E> s1 = new Stack<>();
    Stack<E> s2 = new Stack<>();

    public void enQueue(E data) {
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public E deQueue() {
        if(s1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        return s1.pop();
    }

    public void print() {
        
    }

    public static void main(String[] args) {
        QueueWith2Stack<Integer> queue = new QueueWith2Stack<>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        
        System.out.println();

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}