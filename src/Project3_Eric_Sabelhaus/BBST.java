package Project3_Eric_Sabelhaus;

public class BBST<E> {
	private Node<E> root;
	
	// define colors
	private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
    // is node x red; false if x is null ?
    private boolean isRed(Node<E> node) {
        if (node == null) return false;
        return (node.isColor() == RED);
    }
    
    // insert new data to tree
	public void insert(Integer key, E data) {
		if (data == null) { 
			System.out.println("INSERTION WITHOUT DATA, NOT INSERTING KEY");
			return; 
		} else {
			root = insert(root, key, data);
			root.setColor(BLACK);
		}
	}
	
	// if root is null, assign it, otherwise create new branches/nodes and distribute them
	private Node<E> insert(Node<E> node, Integer key, E data) {
		if (node == null) {
			return new Node<E>(key, data, RED, 1);
		} else {
			int comp = key.compareTo(node.getKey());
			if (comp < 0) {
				node.setL(insert(node.getL(), key, data));
			} else if (comp > 0) {
				node.setR(insert(node.getR(), key, data));
			} else {
				node.setData(data);
			}
			
			// sort out any right-heavy branches
	        if (isRed(node.getR()) && !isRed(node.getL())) {
	        	node = rotateLeft(node);
	        }
	        if (isRed(node.getL())  &&  isRed(node.getL().getL())) {
	        	node = rotateRight(node);
	        }
	        if (isRed(node.getL())  &&  isRed(node.getR())) {
	        	flipColors(node);
	        }
	        
			node.setSub(1 + size(node.getL()) + size(node.getR()));
			return node;
		}
	}
	
    // make a left-leaning branch lean to the right
    private Node<E> rotateRight(Node<E> node) {
        Node<E> rotate = node.getL();
        node.setL(rotate.getR());
        rotate.setR(node);
        rotate.setColor(rotate.getR().isColor());
        rotate.getR().setColor(RED);
        rotate.setSub(node.getSub());
        node.setSub(size(node.getL()) + size(node.getR()) + 1);
        return rotate;
    }

    // make a right-leaning branch lean to the left
    private Node<E> rotateLeft(Node<E> node) {
    	Node<E> rotate = node.getR();
        node.setR(rotate.getL());
        rotate.setL(node);
        rotate.setColor(rotate.getL().isColor());
        rotate.getL().setColor(RED);
        rotate.setSub(node.getSub());
        node.setSub(size(node.getL()) + size(node.getR()) + 1);
        return rotate;
    }

    // flip the colors of a Node and its two children
    private void flipColors(Node<E> node) {
        node.setColor(!node.isColor());
        node.getL().setColor(!node.getL().isColor());
        node.getR().setColor(!node.getR().isColor());
    }
	
	// return number of key-value pairs in BST
	// argument not allowed, as root us not public
    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node<E> node) {
        if (node == null) {
        	return 0;
        }
        else return node.getSub();
    }

    // search for data at a key from the root outward
	public E search(Integer key) {
        return search(root, key);
    }

	// if the tree is empty, return null
	// recursively search from root outward comparing keys to find a match
	// then return the data at that node
    private E search(Node<E> node, Integer key) {
        if (node == null) {
        	return null;
        }
        int comp = key.compareTo(node.getKey());
        if (comp < 0) {
        	return search(node.getL(), key);
        } else if (comp > 0) {
        	return search(node.getR(), key);
        } else {
        	return node.getData();
        }
    }
	
    
    // if the tree is empty, return 0
    // otherwise call recursive in order count from root
	public int getNumberOfLeaves(){
		if (root == null){ 
			return 0;
		}
		
		return inOrderLeafCount(root);
	}
	
	// count each leaf in tree
	private int inOrderLeafCount(Node<E> node){
		if (node.getL() == null || node.getR() == null) {
			return 1;
		} 
		return inOrderLeafCount(node.getL()) + inOrderLeafCount(node.getR());
	}
	
	// if the tree is empty, return 0
    // otherwise call recursive in order count from root
	public int getNumberOfInternalNodes(){
		if (root == null){ 
			return 0;
		}
		return inOrderNodeCount(root);
	}
	
	//count each inner node
	private int inOrderNodeCount(Node<E> node){
		if (node.getL() == null || node.getR() == null) {
			return 0;
		}
		return 1 + inOrderNodeCount(node.getL()) + inOrderNodeCount(node.getR());
		
	}
	
	// execute a recursive pre order traversal from the root of the tree
	public void pre() {
		if (root == null){
			System.out.println("UNABLE TO TRAVERSE EMPTY TREE!!");
			return;
		}
		preOrder(root);
	}
	
	// perform a recursive pre order traversal from the root of the tree
	private void preOrder(Node<E> node) {
		System.out.println(node.getKey() + ", " + node.getData());
		if(node.getL() != null) {
			preOrder(node.getL());
		}
		if(node.getR() != null) {
			preOrder(node.getR());
		}
	}
	
	// execute a recursive in order traversal from the root of the tree
	public void in() {
		if (root == null){
			System.out.println("UNABLE TO TRAVERSE EMPTY TREE!!");
			return;
		}
		inOrder(root);
	}
	
	// perform a recursive in order traversal from the root of the tree
	private void inOrder(Node<E> node) {
		if(node.getL() != null) {
			inOrder(node.getL());
		}
		System.out.println(node.getKey() + ", " + node.getData());
		if(node.getR() != null) {
			inOrder(node.getR());
		}
	}
	
	// execute a recursive post order traversal from the root of the tree
	public void post() {
		if (root == null){
			System.out.println("UNABLE TO TRAVERSE EMPTY TREE!!");
			return;
		}
		postOrder(root);
	}
	
	// perform a recursive post order traversal from the root of the tree
	public void postOrder(Node<E> node) {
		if(node.getL() != null) {
			postOrder(node.getL());
		}
		if(node.getR() != null) {
			postOrder(node.getR());
		}
		System.out.println(node.getKey() + ", " + node.getData());
	}
	
	// height of this BST (one-node tree has height 0)
    public int height() { 
    	return height(root); 
    }
    
    // recursively count height of tree
    private int height(Node<E> node) {
        if (node == null) {
        	return -1;
        }
        return 1 + Math.max(height(node.getL()), height(node.getR()));
    }
	
}
