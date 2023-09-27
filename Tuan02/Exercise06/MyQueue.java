public class MyQueue<E> extends Node implements QueueInterface<E> {
    private Node<E> front;
    private Node<E> rear;
    private int numNode;

    public MyQueue() {
        front = null;
        rear = null;
        numNode = 0;
    }

    public void Enqueue(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        numNode++;
    }

    public E Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        E element = front.getData();
        front = front.getNext();
        numNode--;
        if (isEmpty()) {
            rear = null;
        }
        return element;
    }

    public int size() {
        return numNode;
    }

    public boolean contains(E item) {
        Node<E> current = front;
        while (current != null) {
            if(current.getData().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            Node<E> current = front;
            while (current != null) {
                System.out.print(current.getData());
                current = current.getNext();
                if (current != null)
                    System.out.print(" --> ");
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public E getFront() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        return front.getData();
    }
}