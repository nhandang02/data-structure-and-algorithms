public class CharLinkedList {
    Node head;

    public CharLinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    } 

    public void addFirst(char data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        }

        else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public boolean addAfterFirstKey(char data, char key) {
        Node curr = head;
        Node newNode = new Node(data, null);
        while (curr != null) {
            if (curr.getData() == key) {
                newNode.setNext(curr.getNext());
                curr.setNext(newNode);
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    public int largestCharPosition() {
        Node curr = head;
        int max = 0;
        while (curr != null) {
            if (curr.getData() > max ) max = curr.getData();
            curr = curr.getNext();
        }

        int poss = 0;
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getData() == max) {
                return poss;
            }
            currNode = currNode.getNext();
            poss++;
        }
        return -1;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData());
            curr = curr.getNext();
            if (curr != null) System.out.print("-->");
        }
        System.out.println();
    }

}