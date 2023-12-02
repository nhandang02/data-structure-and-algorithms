public class IntLinkedList implements ListInterface {
    private Node head;

    public IntLinkedList() {
        this.head = null;
    }

    @Override
    public void addFirst(int data) {
        Node newNode = new Node(data, head);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public boolean addLast(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            newNode.next = head;
            head = newNode;
            return true;
        }
        
        Node current_CheckDuplicate = head;
        while (current_CheckDuplicate != null) {
            if (current_CheckDuplicate.getData() == data) return false;
            current_CheckDuplicate = current_CheckDuplicate.getNext();
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
        return true;
    }

    @Override
    public boolean checkSorted() {
        if (head == null) {
            System.out.println("LinkedList is Empty!");
            return true;
        }

        // Node current = head;
        
        // if (current.getData() <= current.getNext().getData()) {
        //     while (current.getNext() != null) {
        //         if (current.getData() > current.getNext().getData()) {
        //             return false;
        //         }
        //         current = current.getNext();
        //     }
        //     return true;
        // }
        // else {
        //     while (current.getNext() != null) {
        //         if (current.getData() < current.getNext().getData()) {
        //             return false;
        //         }
        //         current = current.getNext();
        //     }
        //     return true;
        // }

        Node current = head;
        if (current.getData() <= current.getNext().getData()) {
            while (current.getNext() != null) {
                if (current.getData() > current.getNext().getData()) return false;
                current = current.getNext();
            }
        }
        else {
            while (current.getNext() != null) {
                if (current.getData() < current.getNext().getData()) return false;
                current = current.getNext();
            }
        }
        return true;
    }



    @Override
    public int countOdd() {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (current.getData() % 2 != 0) count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public boolean removeAt(int position) {
        if (head == null) {
            System.out.println("LinkedList is Empty!");
            return false;
        }
        if (position == 1) {
            head = head.getNext();
            return true;
        }
        Node current = head;
        int count = 0;
        Node preNode = null;
        while (current != null) {
            if (count == position-1) {
                preNode.setNext(current.getNext());
                return true;
            }
            preNode = current;
            current = current.getNext();
            count++;
        }
        return false;
    }

    @Override
    public int searchKey(int key) {
        Node current = head;
        int numNode = 1;

        while (current != null) {
            if (current.getData() == key) return numNode;
            current = current.getNext();
            numNode++;
        }
        return -1;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getData());
            curr = curr.getNext();
            if (curr != null)
                System.out.print("-->");
        }
        System.out.println();
    }
}
