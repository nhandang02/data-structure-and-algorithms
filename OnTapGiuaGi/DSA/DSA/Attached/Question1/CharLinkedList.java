public class CharLinkedList implements ListInterface {
    private Node head;
    private int numNode;

    public CharLinkedList() {
        this.head = null;
        this.numNode = 0;
    }

    public Node getHead() {
        return head;
    }

    public int size() {
        return numNode;
    }

    public void addFirst(char data) {
        Node newNode = new Node(data, head);
        newNode.setNext(head);
        head = newNode;
        numNode++;
    }

    public boolean addAfterFirstKey(char data, char key) {
        Node curr = head;
        while(curr != null && curr.getData() != key) {
            curr = curr.getNext();
        }
        if(curr != null) {
            Node newNode = new Node(data, head);
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
            numNode++;
            return true;
        }
        return false;
    }

    public int largestCharPostition() {
        if(head == null) {
            return -1;
        }
        int maxPos = 0;
        int maxVal = head.getData();
        Node curr = head.getNext();
        int pos = 1;
        while(curr != null) {
            if(curr.getData() > maxVal) {
                maxPos = pos;
                maxVal = curr.getData();
            }
            curr = curr.getNext();
            pos++;
        }
        return maxPos;
    }

    public void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.getData() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}