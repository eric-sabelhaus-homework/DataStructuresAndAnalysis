package Project2_Eric_Sabelhaus;

import org.junit.Test;

public class TestHandleSorting {
	
	@Test
	public void TestSS() {
		//test 10 sets of data
		//worst, median, and best cases, as this algorithm will always produce
		//an efficiency of O(n^2)
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			RandomData thisData = new RandomData(size);
			HandleSorting thisSort = new HandleSorting(thisData.getRandomData()); 
			thisSort.selectionSort();
			System.out.println("SS: " + thisSort.toS());
		}
	}
	
	@Test
	public void TestIS() {
		//test 10 sets of data
		//best Case
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			//initialize array for sorting
			RandomData thisData = new RandomData(size);
			//initialize sorting object
			HandleSorting thisSort = new HandleSorting(thisData.getRandomData());
			//Run an initial sort
			thisSort.insertionSort();
			thisSort.jumbleSome();
			//clear counters
			thisSort.clearCounters();
			//run insert sort method on best case data
			thisSort.insertionSort();
			System.out.println("IS_best: " + thisSort.toS());
		}
		//worst and average case
		//The best case for this algorithm is produced when the elements of
		//the array are partially or nearly sorted
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			//initialize array for sorting
			RandomData thisData = new RandomData(size);
			//initialize sorting object
			HandleSorting thisSort = new HandleSorting(thisData.getRandomData()); 
			//run insert sort method on this data
			thisSort.insertionSort();
			System.out.println("IS_worst-average: " + thisSort.toS());
		}
	}
	
	@Test
	public void TestQS() {
		//test 10 sets of data, 
		//best case / average case
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			//initialize array for sorting
			RandomData thisData = new RandomData(size); 
			//initialize sorting object
			HandleSorting thisSort = new HandleSorting(thisData.getRandomData());
			//run quick sort on the array
			thisSort.quickSort(0, size-1);
			//print the data metrics for the sort
			System.out.println("QS_best-average: " + thisSort.toS());
		}
		//worst case
		for (int x = 0; x < 10; x++) {
			//use multiples of 100
			int size = (x+1) * 100;
			//initialize array for sorting
			RandomData thisData = new RandomData(size); 
			//initialize sorting object
			HandleSorting thisSort = new HandleSorting(thisData.getRandomData());
			//run quick sort on the array, but only sort a from 
			//the 16th element of the array to the end
			thisSort.quickSort(16, size-1);
			thisSort.clearCounters();
			//run quick sort on the whole array, which has been almost totally sorted
			thisSort.quickSort(0, size-1);
			//print the data metrics for the sort
			System.out.println("QS_worst: " + thisSort.toS());
		}
	}
}
