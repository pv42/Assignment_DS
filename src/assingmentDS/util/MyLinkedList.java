package assingmentDS.util;

//Hinweis: tabs sollten durch Leerzeichen ersetzt werden
//todo Kommentare!!!!

public class MyLinkedList<T> {
	
	private class Node<T> { //todo das sollte eine privarte Unterklasse von MyLinkedList sein, dann währe in dieser Klasse <T> auch unnötig
		Node next = null; //todo das sollte privat sein und mit gettern und settern realisiert sein!
		T data;
		public Node(T d) {
			data = d;
		}
	}
	
	private Node head;
	private int listCount; //todo der counter ist buganfällig besser währe eine rekursive Längenzälung

	public MyLinkedList() {
		head = new Node(0); //todo eine neue (= leere) List sollte keine Elemente enthalten
		listCount = 0;
	}

	public void show() { //todo besser währe eine Methode, die eine String zurückgibt, der dann ausgegehen werden kann vgl. public String toString()
		Node current = head;
		while (current.next != null) {
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(current.data);
	}

	public int getSize() {
		return listCount;
	} //todo besser währe eine richtige Zählung der Elemente

	public int size(){
		Node current = head;
		int size = 0;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return size;
	}
	
	public boolean add(T data) {
		Node end = new Node(data);
		Node current = head;

		while (current.next != null) {
			current = current.next;
		}
		current.next = end;
		listCount++;
		return true;
	}

	public boolean add(T data, int index) {
		Node node = new Node(data); //todo end ist ein unpassender Name
		Node current = head;
		int jump;

		if ((index > listCount) || (index < 1)) { //todo indizierung bei Listen immer mit 0 beginnend!
			return false;
		} else {
			jump = 0;
			while (jump < index - 1) {
				current = current.next;
				jump++;
			}
			node.next = current.next;
			current.next = node;
			listCount++;
			return true;
		}
	}

	public boolean deleteNodeWithData(T d) { //todo in public boolean remove(T data) ändern
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

	public boolean deleteNodeAtIndex(int index) { //todo in public boolean remove(int index) ändern
		Node current = head;
		int jump;
		if ((index > listCount) || (index < 1)) { // index von 0 bis list.getSize() -1
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
	//todo Eine get(int index) Methode ist dringend erforderlich
	// wenn die Interface List (https://docs.oracle.com/javase/8/docs/api/java/util/List.html) erfüllt würde währe super aber nicht notwendig
}
