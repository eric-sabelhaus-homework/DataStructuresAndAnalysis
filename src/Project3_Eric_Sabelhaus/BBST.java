package Project3_Eric_Sabelhaus;

public class BBST<E> {
	private Node<E> root;
	private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
 // is node x red; false if x is null ?
    private boolean isRed(Node<E> x) {
        if (x == null) return false;
        return (x.isColor() == RED);
    }
    
	public void insert(Integer key, E data) {
		if (data == null) { 
			return; 
		} else {
			root = insert(root, key, data);
			root.setColor(BLACK);
			//balance(root);
		}
	}
	
	private Node<E> insert(Node<E> x, Integer key, E data) {
		if (x == null) {
			return new Node<E>(key, data, RED, 1);
		} else {
			int cmp = key.compareTo(x.getKey());
			if (cmp < 0) {
				x.setL(insert(x.getL(), key, data));
			} else if (cmp > 0) {
				x.setR(insert(x.getR(), key, data));
			} else {
				x.setData(data);
			}
			
			// fix-up any right-leaning links
	        if (isRed(x.getR()) && !isRed(x.getL())) {
	        	x = rotateLeft(x);
	        }
	        if (isRed(x.getL())  &&  isRed(x.getL().getL())) {
	        	x = rotateRight(x);
	        }
	        if (isRed(x.getL())  &&  isRed(x.getR())) {
	        	flipColors(x);
	        }
	        
			//System.out.println(x.getData() + " " + x.getKey());
			x.setSub(1 + size(x.getL()) + size(x.getR()));
			return x;
		}
	}
	
    // make a left-leaning link lean to the right
    private Node<E> rotateRight(Node<E> h) {
        Node<E> x = h.getL();
        h.setL(x.getR());
        x.setR(h);
        x.setColor(x.getR().isColor());
        x.getR().setColor(RED);
        x.setSub(h.getSub());
        h.setSub(size(h.getL()) + size(h.getR()) + 1);
        return x;
    }

    // make a right-leaning link lean to the left
    private Node<E> rotateLeft(Node<E> h) {
    	Node<E> x = h.getR();
        h.setR(x.getL());
        x.setL(h);
        x.setColor(x.getL().isColor());
        x.getL().setColor(RED);
        x.setSub(h.getSub());
        h.setSub(size(h.getL()) + size(h.getR()) + 1);
        return x;
    }

    // flip the colors of a Node<E> and its two children
    private void flipColors(Node<E> h) {
        h.setColor(!h.isColor());
        h.getL().setColor(!h.getL().isColor());
        h.getR().setColor(!h.getR().isColor());
    }
	
	public boolean isEmpty() {
        return size() == 0;
    }
	
	// return number of key-value pairs in BST
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node<E> x) {
        if (x == null) {
        	return 0;
        }
        else return x.getSub();
    }
	
	public Integer min() {
        if (isEmpty()) return null;
        return min(root).getKey();
    } 

    private Node<E> min(Node<E> x) { 
        if (x.getL() == null) {
        	return x; 
        } else {
        	return min(x.getL()); 
        }
    } 
    
    public Integer max() {
        if (isEmpty()) return null;
        return max(root).getKey();
    } 

    private Node<E> max(Node<E> x) { 
        if (x.getR() == null) {
        	return x; 
        } else {
        	return max(x.getR()); 
        }
    }

	public E search(Integer key) {
        return search(root, key);
    }

    private E search(Node<E> x, Integer key) {
        if (x == null) {
        	return null;
        }
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0) {
        	return search(x.getL(), key);
        } else if (cmp > 0) {
        	return search(x.getR(), key);
        } else {
        	return x.getData();
        }
    }
	
	public int getNumberOfLeaves(){
		if (root == null){ 
			return 0;
		}
		
		return inOrderLeafCount(root);
	}
	
	private int inOrderLeafCount(Node<E> n){
		//System.out.println(n.getData());
		if (n.getL() == null || n.getR() == null) {
			return 1;
		} 
		return inOrderLeafCount(n.getL()) + inOrderLeafCount(n.getR());
	}
	
	public int getNumberOfInternalNodes(){
		if (root == null){ 
			return 0;
		}
		return inOrderNodeCount(root);
	}
	
	private int inOrderNodeCount(Node<E> n){
		if (n.getL() == null && n.getR() == null) {
			return 0;
		}
		if (n.getL() != null) {
			return 1 + inOrderNodeCount(n.getL());
		}
		if (n.getR() != null){
			return 1 + inOrderNodeCount(n.getR());
		}
		return 1 + inOrderNodeCount(n.getL()) + inOrderNodeCount(n.getR());
		
	}
	
	public void pre() {
		if (root == null){
			return;
		}
		preOrder(root);
	}
	
	private void preOrder(Node<E> n) {
		System.out.println(n.getKey() + ", " + n.getData());
		if(n.getL() != null) {
			preOrder(n.getL());
		}
		if(n.getR() != null) {
			preOrder(n.getR());
		}
	}
	
	public void in() {
		if (root == null){
			return;
		}
		inOrder(root);
	}
	
	private void inOrder(Node<E> n) {
		if(n.getL() != null) {
			inOrder(n.getL());
		}
		System.out.println(n.getKey() + ", " + n.getData());
		if(n.getR() != null) {
			inOrder(n.getR());
		}
	}
	
	public void post() {
		if (root == null){
			return;
		}
		postOrder(root);
	}
	
	public void postOrder(Node<E> n) {
		if(n.getL() != null) {
			postOrder(n.getL());
		}
		if(n.getR() != null) {
			postOrder(n.getR());
		}
		System.out.println(n.getKey() + ", " + n.getData());
	}
	
	// height of this BST (one-Node<E> tree has height 0)
    public int height() { 
    	return height(root); 
    }
    
    private int height(Node<E> x) {
        if (x == null) {
        	return -1;
        }
        return 1 + Math.max(height(x.getL()), height(x.getR()));
    }
	
}
