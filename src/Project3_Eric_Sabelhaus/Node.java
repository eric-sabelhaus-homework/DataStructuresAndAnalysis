package Project3_Eric_Sabelhaus;

public class Node<E> {
	private E data;
	private Node<E> l, r;
	private Integer key;
	private boolean color;
	private int sub;
	
	public Node(Integer key, E data, boolean color, int sub){
		this.data = data;
		this.key = key;
		this.color = color;
		this.sub = sub;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public Node<E> getL() {
		return l;
	}

	public void setL(Node<E> l) {
		this.l = l;
	}

	public Node<E> getR() {
		return r;
	}

	public void setR(Node<E> r) {
		this.r = r;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	};
}
