public class Node<E> {
    protected E element;
    protected Node next;
    
    public Node() {
        this.element = null;
        this.next = null;
    }

    public Node(E element) {
        this.element = element;
        this.next = null;
    }

    public Node (E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }   

    public E getData() {
        return element;
    } 

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> curr) {
        this.next = curr;
    }
}