package Hw2_Eric_Sabelhaus;

public abstract class HandleMySorting implements Comparable<Object> {

	/**
	 * @param args
	 */

	// Method:  selectionSort
	// Author:  InstructorX , Modified by Eric Sabelhaus
	// Date:    01/31/15
	// Purpose: A method that sorts an array using a selection sort

	public static void selectionSort(Integer[] myArray) {
		//iteration counter
		int iterCounter = 0;
		//assignment counter
		int assignCounter = 0;
		//selection sort, outer loop
		for (int i = 0; i < myArray.length; i++) {
			//count iteration
			iterCounter++;
			System.out.println("Current Amount Iterations: " + iterCounter);
			System.out.println("Current Amount Assignments:"+ assignCounter);
			//selection sort, inner loop
			for (int j = i + 1; j < myArray.length; j++) {
				//count iteration
				iterCounter++;
				
				if (myArray[j].compareTo(myArray[i]) < 0) {
					//count assignment
					assignCounter++;
					//perform assignment
					swap(myArray, j, i);
				}
			}
		}
		System.out.println("Select Sort, Length " + myArray.length + ", Total Iterations " + 
				iterCounter + ", Total Assignments " + assignCounter + ", Overall Total " + 
				(iterCounter + assignCounter));
	}

	// Method:  insertionSort
	// Author:  InstructorX , Modified by Eric Sabelhaus
	// Date:    01/31/15
	// Purpose: A method that sorts an array using an insertion sort

	public static void insertionSort(Integer[] myArray) {
		//iteration counter
		int iterCounter = 0;
		//assignment counter
		int assignCounter = 0;
		//insert sort, outer loop
		for (int i = 1; i < myArray.length; i++) {
			//count iteration
			iterCounter++;
			System.out.println("Current Amount Iterations: " + iterCounter);
			System.out.println("Current Amount Assignments:"+ assignCounter);
			Integer temp = myArray[i];
			int j = i - 1;
			//insert sort, inner loop
			while (j >= 0 && temp.compareTo(myArray[j]) < 0) {
				myArray[j + 1] = myArray[j];
				//count iteration
				iterCounter++;
				//count assignment
				assignCounter++;
				j--;
			}
			myArray[j +1 ] = temp;
		}
		System.out.println("Insert Sort, Length " + myArray.length + ", Total Iterations " + 
				iterCounter + ", Total Assignments " + assignCounter + ", Overall Total " + 
				(iterCounter + assignCounter));
	}

	// Method:  swap
	// Author:  InstructorX
	// Date:    01/31/15
	// Purpose: A method that swaps two array elements

	@SuppressWarnings("rawtypes")
	private static void swap(Comparable[] array, int i, int j)
	{
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
