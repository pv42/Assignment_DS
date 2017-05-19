package assingmentDS.util;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> extends AbstractList<T> {

    private class Node {
        private Node next = null;
        private T data;
        Node(T d) {
            data = d;
        }

        void setNext(Node next){
            this.next = next;
        }

        Node getNext(){
            return this.next;
        }

        T getData(){
            return this.data;
        }
    }

    private class MyListIterator implements Iterator<T>{
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

        public T current() {
            return get(index);
        }
    }

    private Node head;

    public MyLinkedList() {
        head = null;
    }

    @Override
    public String toString() {
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

    @Override
    public boolean remove(Object data) {
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

    @Override
    public T remove(int index) {
        Node current = head;
        int jump;
        if ((index >= size()) || (index < 0)) {
            return null;
        } else {
            jump = 0;
            while (jump < index) {
                current = current.getNext();
                if(current == null) return null;
                jump++;
            }
            if(current.getNext() != null) {
                current.setNext(current.getNext().getNext());
                return current.getNext().getData();
            }
            return null;

        }
    }

    public T get(int index){
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getData();

    }

    @Override
    public MyListIterator iterator(){
        return new MyListIterator();
    }

    @Override
    public void clear() {
        head = null;
    }


    // wenn die Interface List (https://docs.oracle.com/javase/8/docs/api/java/util/List.html) erfüllt würde währe super aber nicht notwendig
}
