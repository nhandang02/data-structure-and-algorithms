public class MyStack<E> implements StackInterface<E> {   
    private Node<E> top;
    private int numNode;

    public MyStack() {
        top = null;
        numNode = 0;
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        numNode++;
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
        }
        E element = top.getData();
        top = top.getNext();
        numNode--;
        return element;
    }

    public int size() {
        return numNode;
    }

    public boolean contains(E item) {
        Node<E> current = top;
        while (current != null) {
            if (current.getData().equals(item)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void print() {
    if (isEmpty()) {
        System.out.println("Stack is empty.");
    } else {
        Node<E> current = top;
        while (current != null) {
            System.out.print(current.getData());
            current = current.getNext();
            if(current != null)
                System.out.print("-->");
        }
        System.out.println();
        }
    }

    public boolean isEmpty() {
        return numNode == 0;
    }

    public E getPeek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
        }
        return top.getData();
    }
}
