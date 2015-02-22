package Project3_Eric_Sabelhaus;

import org.junit.*;

public class TestBBST {
	
	@Test
	public void testWithStrings(){
		BBST<String> test = new BBST<String>();

		test.insert(1, "foo");
		test.insert(2, "bar");
		test.insert(4, "bang");
		test.insert(8, "baz");
		test.insert(16, "qux");
		test.insert(32, "norf");
		test.insert(64, "floof");
		test.insert(128, "woot");
		test.insert(256, "aaaaayyyyyy!");
		test.insert(512, "blang");
		test.insert(1024, "el-kabong");
		test.insert(2048, "1.21 jiggawats");
		
		/*
		  	in-order traversal;
			search for an existing key;
			search for a key that does not belong to the BST;
			calculate the height;
			count the leaves;
			count the internal nodes;
			insert a new key;
			calculate the height;
			inorder traversal;
			preorder traversal;
			postorder traversal;
			count the leaves;
			count the internal nodes;
		 */
		System.out.println("begin in order traversal\n");		
		test.in();
		System.out.println("\nend in order traversal\n");
		System.out.println("\nsearch for data at key 256\n");
		System.out.println(test.search(256));
		System.out.println("\nsearch for data at key 42\n");
		System.out.println(test.search(42));
		System.out.println("\nretrieve current height\n");
		System.out.println(test.height());
		System.out.println("\nget number of leaves\n");
		System.out.println(test.getNumberOfLeaves());
		System.out.println("\nget number of internal nodes\n");
		System.out.println(test.getNumberOfInternalNodes());
		System.out.println("\ninsert new node");
		test.insert(42, "The Answer To Everything That Is Anything");
		System.out.println("retrieve current height\n");
		System.out.println(test.height());
		System.out.println("\nbegin in order traversal\n");
		test.in();
		System.out.println("\nend in order traversal\n");
		System.out.println("begin pre order traversal\n");
		test.pre();
		System.out.println("\nend pre order traversal\n");
		System.out.println("\nbegin post order traversal");
		test.post();
		System.out.println("\nend post order traversal\n");
		System.out.println("get number of leaves\n");
		System.out.println(test.getNumberOfLeaves());
		System.out.println("\nget number of internal nodes\n");
		System.out.println(test.getNumberOfInternalNodes());
		
	}
	
	
	
	
}
