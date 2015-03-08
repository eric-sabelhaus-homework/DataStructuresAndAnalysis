package FinalProject_Eric_Sabelhaus;

public class Node<Edge> {
	
	private Edge edge;
	
	private Node<Edge> next;
	
	
	public Edge getEdge() {
		return edge;
	}
	
	public void setEdge(Edge i) {
		this.edge = i;
	}
	
	public Node<Edge> getNext() {
		return next;
	}
	
	public void setNext(Node<Edge> next) {
		this.next = next;
	}
}