public class MyStack<E> implements StackInterface<E> {
    private Node<E> top;
    private int numNode;

    public MyStack() {
        this.top = null;
        this.numNode = 0;
    } 

    @Override
    public void push(E item) {
        Node<E> newNode = new Node(item);
        newNode.setNext(top);
        top = newNode;
        numNode++;
    }

    @Override
    public E pop() {
        if (isEmpty())  System.out.println("Stack is Empty!");
        E item = top.getData();
        top = top.getNext();
        numNode--;
        return item;
    }

    @Override
    public int size() {
        return numNode;

    }

    @Override
    public boolean contains(E item) {
        Node<E> current = top;
        while(current != null) {
            if(current.getData().equals(item)) return true;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void print() {
        if(isEmpty()) System.out.println("Stack is Empty!");
        else {
            Node<E> current = top;
            while(current != null) {
                System.out.print(current.getData());
                current = current.getNext();
                if (current != null)    System.out.print("-->");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isEmpty() {
        return numNode == 0;
    }

    @Override
    public E getPeek() {
        if (isEmpty()) System.out.println("Stack is Empty!");
        return top.getData();
    }
}