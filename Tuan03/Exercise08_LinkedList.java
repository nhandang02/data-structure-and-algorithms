public class Exercise08_LinkedList<E extends Comparable<E>>{
    private Node<E> head;

    private class Node<E> {
        private E data;
        private Node<E> next;
        
        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public Exercise08_LinkedList() {
        this.head = null;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) head = newNode;
        else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addSortedList(E data) {
        Node<E> newNode = new Node<>(data);
        Node<E> current = head;
        while (current.next.data.compareTo(data) < 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void remove(E data) {
        if (head == null)   System.out.println("LinkedList is Empty!");

        if (head.data.equals(data)) {
            head = head.next;
        }

        Node<E> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public int countEvenNum() {
        if (head == null)   System.out.println("LinkedList is Empty!");
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.data instanceof Integer) {
                Integer value = (Integer) current.data;
                if (value % 2 == 0) {
                    count++;
                }
            }
            current = current.next;
        }
        return count;
    }

    public int sumAllNum() {
        if (head == null)   System.out.println("LinkedList is Empty!");
        int sum = 0;
        Node<E> current = head;
        while (current != null) {
            if (current.data instanceof Integer) {
                Integer value = (Integer) current.data;
                sum += value;
            }
            current = current.next;
        }
        return sum;
    }

    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current != null)    System.out.print("--> ");
        }
        System.out.println();
    }
}
