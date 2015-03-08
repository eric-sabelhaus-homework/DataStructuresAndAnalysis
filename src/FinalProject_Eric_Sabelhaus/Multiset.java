package FinalProject_Eric_Sabelhaus;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Multiset<Edge> implements Iterable<Edge> {
    private int elements;               // number of elements in multiset
    private Node<Edge> first;    // beginning of multiset

    /**
     * Initializes an empty multiset.
     */
    public Multiset() {
        first = null;
        elements = 0;
    }

    /**
     * Is this multiset empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this multiset.
     */
    public int size() {
        return elements;
    }

    /**
     * Adds the item to this multiset.
     */
    public void add(Edge i) {
        Node<Edge> oldfirst = first;
        first = new Node<Edge>();
        first.setEdge(i);
        first.setNext(oldfirst);
        elements++;
    }

	@Override
	public Iterator<Edge> iterator() {
		return new ListIterator<Edge>(first);
	}
	
	@SuppressWarnings("hiding")
	private class ListIterator<Edge> implements Iterator<Edge> {
        private Node<Edge> current;

        public ListIterator(Node<Edge> first) {
            current = first;
        }

        public boolean hasNext() { 
        	return current != null;
        }
        public void remove() { 
        	throw new UnsupportedOperationException();
        }

        public Edge next() {
            if (!hasNext()) {
            	throw new NoSuchElementException();
            }
            Edge thisEdge = current.getEdge();
            current = current.getNext(); 
            return thisEdge;
        }
    }
}