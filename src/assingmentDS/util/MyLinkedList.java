package assingmentDS.util;

//Hinweis: tabs sollten durch Leerzeichen ersetzt werden
//todo Kommentare!!!!

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Collection<T>{
	
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
		while (current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        //todo
        return false;
    }

    public boolean add(T data) {
		Node end = new Node(data);
        if(head == null) {
            head = end;
            return true;
        }
        Node current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		current.setNext(end);
		return true;
	}


    public boolean add(T data, int index) {
		if (index < 0) return false;
		Node node = new Node(data);
		Node current = head;
		int jump = 0;
        while (jump < index ) {
            if(current == null) return false;
            current = current.getNext();
            jump++;
		}
		if (current == null) {
		    head = node;
        } else {
            current.setNext(node);
            node.setNext(current.getNext());
        }
        return true;
	}

	public boolean remove(Object data) { //todo in public boolean remove(T data) ändern
		Node current = head;
		while (current.getNext() != null) {
			if (current.getNext().getData().equals(data)) {
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

	private class MyListIterator implements Iterator{
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
            throw new UnsupportedOperationException();
        }

        public T current() {
            return get(index);
        }
    }
	public MyListIterator iterator(){
		return new MyListIterator();
	}

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Iterator iterator = iterator();
        int index = 0;
        while (iterator.hasNext()) {
            arr[index] = iterator.next();
            index ++;
        }
        return arr;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean ret = true;
        for(Object o:c) {
            if (o != null) {
                ret = ret && add((T)o);
            } else {
                ret = false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean retainAll(Collection c) {
        //todo
	    return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean ret = true;
	    for(Object o:c) {
            ret = ret && remove(o);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object o:c) {
            if(!contains(o)) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
	    //return new Object[0];
    }


    // wenn die Interface List (https://docs.oracle.com/javase/8/docs/api/java/util/List.html) erfüllt würde währe super aber nicht notwendig
}
