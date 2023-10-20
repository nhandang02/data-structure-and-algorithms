import java.util.*;

class IntLinkedList implements IntListInterface{

	// Data attributes
	private Node head = null;
	private int num_nodes = 0;

	// Return true if list is empty; otherwise return false.
	public boolean isEmpty() { 
		return (num_nodes == 0); 
	}

	// Return number of nodes in list.
	public int size() { 
		return num_nodes; 
	}

	// Return value in the first node.
	public int getFirst() throws NoSuchElementException {
		if (head == null) 
			throw new NoSuchElementException("can't get from an empty list");
		else return head.getData();
	}

	// Return true if list contains item, otherwise return false.
	public boolean contains(int item) {
		for (Node n = head; n != null; n = n.getNext())
			if (n.getData()==item) return true;

		return false;
	}

	// Add item to front of list.
	public void addFirst(int item) {
		head = new Node(item, head);
		num_nodes++;
	}

	public boolean removeAt(int pos) {
		if(pos < 1 || pos > num_nodes) {
			return false;
		} 

		if(pos == 1) {
			head = head.getNext();
			num_nodes--;
			return true;
		}

		Node curr = head;
		Node prev = null;

		for(int i = 1; i < pos; i++) {
			prev = curr;
			curr = curr.getNext();
		}

		prev.setNext(curr.getNext());
		num_nodes--;
		return true;
	}

	public int searchKey(int key) {
		Node curr = head;
		int pos = 1;
		while(curr != null) {
			if(curr.getData() == key) {
				return pos;
			}
			curr = curr.getNext();
			pos++;
		}
		return -1;
	}

	public int countOdd() {
		int count = 0;
		Node curr = head;

		while(curr != null) {
			if(curr.getData() % 2 != 0) {
				count++;
			}
			curr = curr.getNext();
		}
		return count;
	}

	// Remove first node of list.
	public int removeFirst() throws NoSuchElementException {
		Node ln;
		if (head == null) 
			throw new NoSuchElementException("can't remove from an empty list");
		else { 
			ln = head;
			head = head.getNext();
			num_nodes--;
			return ln.getData();
		}
	}

	public boolean checkSorted() {
		if(head == null || head.getNext() == null) {
			return true;
		}

		boolean asc = true;
		boolean desc = true;
		Node curr = head;

		while(curr.getNext() != null && asc) {
			if(curr.getData() > curr.getNext().getData()) {
				asc = false;
			}
			curr = curr.getNext();
		}

		while(curr.getNext() != null && desc) {
			if(curr.getData() < curr.getNext().getData()) {
				desc = false;
			}
			curr = curr.getNext();
		}

		return asc || desc;
	}

	// Print values of nodes in list.
	public void print() throws NoSuchElementException {
		if (head == null)
			throw new NoSuchElementException("Nothing to print...");

		Node ln = head;
		System.out.print("List is: " + ln.getData());
		for (int i=1; i < num_nodes; i++) {
			ln = ln.getNext();
			System.out.print(", " + ln.getData());
		}
		System.out.println(".");
	}

	public boolean addLast(int item) {
		Node curr=head;
		if(contains(item))
			return false;
		else{
			if(curr==null){
				head=new Node(item);
				head.setNext(null);
			}
			else{
				while(curr.getNext()!=null)
					curr=curr.getNext();
				//add new node to the end
				Node toAppendEnd=new Node(item);
					curr.setNext(toAppendEnd);
			}
			num_nodes++;
			return true;
		}
	}
}