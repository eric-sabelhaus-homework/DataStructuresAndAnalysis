package Project2_Eric_Sabelhaus;
public class HandleSorting {

	/**
	 * @param args
	 */
	
	//private array object for sorting purposes
	private Integer[] myArray;
	//iteration counter
	private int comparisonCounter;
	//assignment counter
	private int assignCounter;
	
	// Method: 	HandleMySorting Constructor
	// Author: 	Eric Sabelhaus
	// Date:	02/07/15
	// Purpose:	initialize a private array to be sorted
	HandleSorting(Integer[] array) {
		myArray = array;
	}
	
	// Method:  selectionSort
	// Author:  InstructorX , Modified by Eric Sabelhaus
	// Date:    01/31/15
	// Purpose: A method that sorts an array using a selection sort
	public void selectionSort() {
		//selection sort, outer loop
		for (int i = 0; i < myArray.length; i++) {
			System.out.println("Current Amount Iterations: " + comparisonCounter);
			System.out.println("Current Amount Assignments:"+ assignCounter);
			//selection sort, inner loop
			for (int j = i + 1; j < myArray.length; j++) {
				//count comparison
				comparisonCounter++;
				if (myArray[j].compareTo(myArray[i]) < 0) {
					//perform assignment
					swap(j, i);
				}
			}
		}
		
	}

	// Method:  insertionSort
	// Author:  InstructorX , Modified by Eric Sabelhaus
	// Date:    01/31/15
	// Purpose: A method that sorts an array using an insertion sort
	public void insertionSort() {
		//insert sort, outer loop
		for (int i = 1; i < myArray.length; i++) {
			System.out.println("Current Amount Iterations: " + comparisonCounter);
			System.out.println("Current Amount Assignments:"+ assignCounter);
			Integer temp = myArray[i];
			//count assignment
			assignCounter++;
			int j = i - 1;
			//insert sort, inner loop
			//count comparison
			comparisonCounter++;
			while (j >= 0 && temp.compareTo(myArray[j]) < 0) {
				myArray[j + 1] = myArray[j];
				//count assignment
				assignCounter++;
				j--;
			}
			myArray[j +1] = temp;
			//count assignment
			assignCounter++;
		}
	}

	// Method:  quickSort
	// Author:  instructorX
	// Date:    dd/mm/yyyy
	// Purpose: A method that sorts an array using a quick sort
	//			The pivot will be determined by findPivot
	public void quickSort(int left, int right) {
		if (left <= right) {
			System.out.println("Current Amount Iterations: " + comparisonCounter);
			System.out.println("Current Amount Assignments:"+ assignCounter);
			int pivot = findPivot(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}

	//output the final set of data for length, comparisons, assignments, and total
	public String toS(){
		return "L:" + myArray.length + ", C:" + 
				comparisonCounter + ", A:" + assignCounter + ", T:" + 
				(comparisonCounter + assignCounter);
	}
	
	//output the elements of myArray iteratively
	public void printMyArray(){
		for(int i=0; i<myArray.length; i++){
			System.out.println("index:" + i + ", element:" + myArray[i]);
		}
	}
	
	//jumble a few points of data in myArray 
	public void jumbleSome(){
		myArray[myArray.length/3] = myArray[myArray.length/2];
		myArray[myArray.length/2] = myArray[myArray.length/4];
		myArray[myArray.length/5] = myArray[myArray.length-1];
	}
	
	//reset both counting integers to 0
	public void clearCounters(){
		assignCounter = 0;
		comparisonCounter = 0;
	}
	
	
	// Method:  findPivot
	// Author:  instructorX
	// Date:    dd/mm/yyyy
	// Purpose: A method that locates the position of one element
	//	        by placing everything less to the right and everything
	//	        greater to the right
	private int findPivot(int left, int right) {
		int first = left++;
		//main loop
		while (left <= right) {
			//comparison
			while (left <= right && myArray[first].compareTo(myArray[left]) > 0) {
				left++;
			}
			//comparison
			while (left <= right && myArray[first].compareTo(myArray[right]) < 0) {
				right--;
			}
			if (left <= right) {
				swap(left++, right--);
			}			
			//count 2 comparisons for each iteration
			comparisonCounter+=2;
		}
		swap(first, right);
		return right;
	}
	
	// Method:  swap
	// Author:  InstructorX, modified by Eric Sabelhaus
	// Date:    01/31/15
	// Purpose: A method that swaps two array elements of myArray
	private void swap(int i, int j)
	{
		//Each swap creates 3 assignments
		assignCounter+=3;
		Integer temp = myArray[i];
		myArray[i] = myArray[j];
		myArray[j] = temp;
	}
	
}
