package Hw3_Eric_Sabelhaus;

public class CircularDoublyLinkedList<E> {
	private class Node {
		public E data;
        public Node forward;
        public Node backward;
    }
	
	private Node prev;
	private Node next;
	private Node head;
	private Node tail;
	
	private int size;
	private int index = 0;
	private Node current = null;
	private Node lastAccessed = null;
	
	
	CircularDoublyLinkedList() {
		prev = new Node();
		next = new Node();
		size = 0;
		head = null;
		tail = null;
		prev.forward = next;
		next.backward = prev;
		current = prev.forward;
		lastAccessed = null;
	}
	
	
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E data) {
        Node last = next.backward;
        Node x = new Node();
        x.data = data;
        x.forward = next;
        x.backward = last;
        next.backward = x;
        last.forward = x;
        lastAccessed = last;
        current = x;
        if (size == 0) {
			head = x;
			tail = x;
		} else {
			tail = x;
		}
        size++;
    }
	
	public void remove(E data) {
		int n = 0;
		if (size == 0) 
			throw new IllegalStateException();
		while (n < size){
			if (this.next() == data){
				Node x = lastAccessed.backward;
		        Node y = lastAccessed.forward;
		        x.forward = y;
		        y.backward = x;
		        size--;
		        if (current == lastAccessed) {
		            current = y;
		        } else {
		            index--;
		        }
		        if (lastAccessed == tail){
		        	tail = y;
		        } else if (lastAccessed == head){
		        	head = y;
		        }
		        lastAccessed = null;
			}
			n++;
		}
	}
	
	
	public E next() {
		E data;
		if (current == tail){
			index = 0;
			lastAccessed = tail;
			data = tail.data;
			current = head;
		} else {
			lastAccessed = current;
	        data = current.data;
	        current = current.forward;
			index++;
		}
		return data;
	}
	
	public int previousIndex() {
		return index--;
	}
	
	public int nextIndex() {
		return index;
	}
	
	public E previous() {
		E data;
		if (current == head){
			current = tail;
			index = size;
			data = current.data;
		} else {
			current = current.backward;
			index--;
			lastAccessed = current;
			data = current.data;
		}
		return data;
	}
	
	public void set(E data) {
		if (lastAccessed == null) {
			throw new IllegalStateException();
		}
        lastAccessed.data = data;
	}

}
