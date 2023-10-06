public class MyQueue<E> implements QueueInterface<E> {
    private Node<E> front;
    private Node<E> rear;
    private int numNode;

    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.numNode = 0;
    }

    @Override
    public void enQueue(E item) {
        Node<E> newNode = new Node(item);
        if(isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
        }
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
        numNode++;
    }

    @Override
    public E deQueue() {
        if(isEmpty())   System.out.println("Queue is Empty!");
        E item = front.getData();
        front = front.getNext();
        numNode--;
        if(isEmpty())   rear = null;
        return item;
    }

    @Override
    public int size() {
        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Node<E> current = front;
        while(current != null) {
            if(current.getData().equals(item)) return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        if(isEmpty())   System.out.println("Queue is Empty!");
        else {
            Node<E> current = front;
            while(current != null) {
                System.out.print(current.getData());
                current = current.getNext();
                if(current != null) System.out.print("-->");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isEmpty() {
        return numNode == 0;
    }
     
    @Override
    public E getFront() {
        return front.getData();
    }
}