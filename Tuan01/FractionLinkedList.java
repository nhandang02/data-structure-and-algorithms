public class FractionLinkedList <Fraction> {

    private Node head;

    public FractionLinkedList() {
        this.head = null;
    }

    public void add(Fraction fraction) {
        Node newNode = new Node(fraction);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

     public void removeFraction(Fraction fraction) {
        if (head == null)
            return;

        if (head.data.equals(fraction)) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.data.equals(fraction)) {
            previous = current;
            current = current.next;
        }

        if (current != null) {
            previous.next = current.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}