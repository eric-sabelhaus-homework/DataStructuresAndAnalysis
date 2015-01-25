package Project1_Eric_Sabelhaus;

import java.util.ArrayList;
import java.util.ListIterator;

//security line class
public class SecurityLine {
	
	//Array of people to be initialized when Security line is instantiated.
	//I chose ArrayList as my list object due to the nature of Queues
	//adding/removing from the top or bottom of the list is a very simple operation
	//and it keeps the queue efficient during runtime.
	//I initialized the ArrayList with a size of 20, as that is the largest number I expect
	//the list to be. However, were it to be larger, it would simply expand to meet the need.
	private ArrayList<String> people = new ArrayList<String>(20);

	//create a place keeper so we can keep count of how many passengers 
	//have been processed in total
	private int startingPoint = 20;
	
	//initialize our line with 20 people
	public SecurityLine(){
		for(int i = 0; i < startingPoint; i++){
			people.add("Passenger_" + i);
		}
	}

	//Add people to the end of the line
	public void addPeople(int howMany) {
		for(int i = 0; i < howMany; i++){
			startingPoint++;
			people.add("Passenger_" + startingPoint);
		}
	}
	
	//Remove people from the front of the line
	public void removePeople(int howMany) {
		for(int i = 0; i < howMany; i++){
			System.out.println("Checked: " + people.get(0));
			people.remove(0);
		}
	}
	
	//Who is in the line right now?
	public String toS(){
		String thisString = "\nAirport Security Line\n=======================\n\n";
		ListIterator<String> litr = people.listIterator();
		while (litr.hasNext()) {
			thisString += litr.next() + "\n";
		}
		return thisString;
	}
	
}
