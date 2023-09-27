public class QueueWith2Stack<E> {
    private MyStack<E> stack1; 
    private MyStack<E> stack2;

    public QueueWith2Stack() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    public void Enqueue(E element) {
        stack1.push(element);
    }

    public E Dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop(); 
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}