public class CharLinkedList implements ListInterface {
    Node head;

    public CharLinkedList() {
        head = null;
    }

    @Override
    public boolean addAfterFirstKey(char data, char key) {
        Node newNode = new Node(data, null);
        Node current = head;
        while (current != null) {
            if (current.getData() == key) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void addFirst(char data) {
        Node newNode = new Node(data, head);
        head = newNode;
    }

    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public int largestCharPostition() {
        Node current = head;
        int max = 0;
        while (current != null) {
            if (current.getData() > max) {
                max = current.getData();
            }
            current = current.getNext();
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
        Node current = head;
        while (current != null) {
            System.out.print(current.getData());
            current = current.getNext();
            if (current != null) System.out.print("-->");
        }
        System.out.println();
    }
    
}
