package Project2_Eric_Sabelhaus;

import java.util.Random;

public class RandomData {

	//random number generator
	private Random rand = new Random();
	//private array object for sorting purposes
	private Integer[] myArray;
	// This is set to 101 due to the nature of random. It is exclusive of the range maximum
	private int max = 101;
	
	// Method: 	RandomData Constructor
	// Author: 	Eric Sabelhaus
	// Date:	02/07/15
	// Purpose:	Construct an array of random numbers
	RandomData(int size) {
		myArray = new Integer[size];
		for (int i = 0; i < size; i++) {
			myArray[i] = rand.nextInt(max);
		}
	}
	
	public Integer[] getRandomData(){
		return myArray;
	}

}
