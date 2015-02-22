package Hw2_Eric_Sabelhaus;

import java.util.Random;
import org.junit.Test;

public class TestHandleMySorting {
	// This is set to 101 due to the nature of random. It is exclusive of the range maximum
	private int max = 101;
		
	Random rand = new Random();
	
	@Test
	public void TestSS() {
		//test 10 sets of data
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			//initialize array for sorting
			Integer[] myArray = new Integer[size];
			//generate random numbers between 0 and 100 (inclusive)
			//insert random into the array
			for (int i = 0; i < size; i++) {
				myArray[i] = rand.nextInt(max);
			}
			//pass array to sorting method
			HandleMySorting.selectionSort(myArray);
		}
	}
	
	@Test
	public void TestIS() {
		//test 10 sets of data
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			//initialize array for sorting
			Integer[] myArray = new Integer[size]; 
			//generate random numbers between 0 and 100 (inclusive)
			//insert random into the array
			for (int i = 0; i < size; i++) {
				myArray[i] = rand.nextInt(max);
			}
			//pass array to sorting method
			HandleMySorting.insertionSort(myArray);
		}
	}
}
