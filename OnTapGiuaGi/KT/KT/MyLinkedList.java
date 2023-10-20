public class MyLinkedList implements ListInterface {
    private Node head;

    public MyLinkedList() {}

    public Node getHead() { 
        return this.head; // Do not modify this method
    }

    @Override
    public void addFirst(int data) {
        // YOUR CODE HERE
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    @Override
    public int find(int x) {
        // YOUR CODE HERE
        int poss = 0;
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getData() == x) return poss;
            currNode = currNode.getNext();
            poss++;
        }
        return -10;
    }

    @Override
    public void times(int x) {
        // YOUR CODE HERE
        Node curNode = head;
        while (curNode != null) {
            curNode.setData(curNode.getData()*x);
            curNode = curNode.getNext();
        }
    }

    public void print() {
        Node tmp = head;
		if (tmp == null) {
			System.out.println("Empty list");
            return;
		}
		while (tmp != null) {
			System.out.print(tmp.getData());
			tmp = tmp.getNext();
            if (tmp != null) System.out.print("-->");
		}
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.print();
        System.out.println(list.find(3));
        list.times(10);
        list.print();
    }
}