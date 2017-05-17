package assingmentDS.util;

class Node<T> {
	Node next = null;
	T data;

	public Node(T d) {
		data = d;
	}
}

public class MyLinkedList<T> {
	private Node head;
	private int listCount;

	public MyLinkedList() {
		head = new Node(0);
		listCount = 0;
	}

	public void show() {
		Node current = head;
		while (current.next != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}

	public int getSize() {
		return listCount;
	}

	public boolean add(T d) {
		Node end = new Node(d);
		Node current = head;

		while (current.next != null) {
			current = current.next;
		}
		current.next = end;
		listCount++;
		return true;
	}

	public boolean add(T d, int index) {
		Node end = new Node(d);
		Node current = head;
		int jump;

		if ((index > listCount) || (index < 1)) {
			return false;
		} else {
			jump = 0;
			while (jump < index - 1) {
				current = current.next;
				jump++;
			}
			end.next = current.next;
			current.next = end;
			listCount++;
			return true;
		}
	}

	public boolean deleteNodeWithData(T d) {
		Node current = head;
		while (current.next != null) {
			if (current.next.data == d) {
				current.next = current.next.next;
				listCount--;
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean deleteNodeAtIndex(int index) {
		Node current = head;
		int jump;
		if ((index > listCount) || (index < 1)) {
			return false;
		} else {
			jump = 0;
			while (jump < index - 1) {
				current = current.next;
				jump++;
			}
			current.next = current.next.next;
			listCount--;
			return true;
		}
	}
	
}