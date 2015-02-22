package Hw3_Eric_Sabelhaus;

import org.junit.*;

public class TestCircularDoublyLinkedList {

	@Test
	public void testWithString() {
		//instantiate circular doubly linked list
		CircularDoublyLinkedList<String> test = new CircularDoublyLinkedList<String>();
		
		//add data to the list
		test.add("foo");
		test.add("bar");
		test.add("baz");
		test.add("qux");
		test.add("norf");

		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		test.remove("norf");
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());		
	}
	
	@Test
	public void testWithInt() {
		CircularDoublyLinkedList<Integer> test = new CircularDoublyLinkedList<Integer>();
		//add integers to the list
		test.add(1);
		test.add(3);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(11);
		
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		System.out.println(test.next());
		test.remove(11);
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());
		System.out.println(test.previous());

	}

}
