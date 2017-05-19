package assingmentDS.util;

//Hinweis: tabs sollten durch Leerzeichen ersetzt werden
//todo Kommentare!!!!

public class MyLinkedList<T> {
	
	private class Node {
		private Node next = null;
		private T data;
		public Node(T d) {
			data = d;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public Node getNext(){
			return this.next;
		}
		
		public void setData(T data){
			this.data = data;
		}
		
		public T getData(){
			return this.data;
		}
	}
	
	private Node head;
	
	public MyLinkedList() {
		head = null;
	}

	@Override
	public String toString() { //todo besser währe eine Methode, die eine String zurückgibt, der dann ausgegehen werden kann vgl. public String toString()
		Node current = head;
		String str = "";
		while (current.getNext() != null) {
			str = str + current.getData() + " -> ";
			current = current.getNext();
		}
		str = str + current.getData();
		return str;
	}
	
	public int size(){
		Node current = head;
		int size = 0;
		while (current.getNext() != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}
	
	public boolean add(T data) {
		Node end = new Node(data);
		Node current = head;

		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(end);
		return true;
	}

	public boolean add(T data, int index) {
		Node node = new Node(data); //todo end ist ein unpassender Name
		Node current = head;
		int jump;

		if ((index > size()) || (index < 1)) { //todo indizierung bei Listen immer mit 0 beginnend!
			return false;
		} else {
			jump = 0;
			while (jump < index - 1) {
				current = current.getNext();
				jump++;
			}
			node.setNext(current.getNext());
			current.setNext(node);
			return true;
		}
	}

	public boolean remove(T data) { //todo in public boolean remove(T data) ändern
		Node current = head;
		while (current.getNext() != null) {
			if (current.getNext().getData() == data) {
				current.setNext(current.getNext().getNext());
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	public boolean remove(int index) { //todo in public boolean remove(int index) ändern
		Node current = head;
		int jump;
		if ((index > size()) || (index < 1)) { // index von 0 bis list.getSize() -1
			return false;
		} else {
			jump = 0;
			while (jump < index - 1) {
				current = current.getNext();
				jump++;
			}
			current.setNext(current.getNext().getNext());
			return true;
		}
	}
	
	public T get(int index){
		Node current = head;
		for (int i = 0; i < index; i++){
			current = current.getNext();
		}
		return current.getData();

	}

	public Iterator<T> iterator(){
		return new Iterator<T>(){
			private int index = 0;
			int listSize = size();

			public boolean hasNext(){
				return index < listSize;
			}

			public T next(){
				if (!hasNext()) throw new NoSuchElementException();
				index++;
				return current();
			}
			public void remove(){
				throw new UnsupportedOperationException():
			}


//			public T current(){
//				return MyLinkedList<T>.get(index):
//			}
//
//			public T get(int i){
//				return MyLinkedList<T>.get(i);
//			}
		}
	}
	
	//todo Eine get(int index) Methode ist dringend erforderlich
	// wenn die Interface List (https://docs.oracle.com/javase/8/docs/api/java/util/List.html) erfüllt würde währe super aber nicht notwendig
}
