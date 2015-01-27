package Project1_Eric_Sabelhaus;

public class SecurityGuard {

	//Initialize private integer to be set by instantiating object
	private int numberPersons;
	
	//define constructor, accept integer
	SecurityGuard(int thisNumberPersons) {
		if(thisNumberPersons <= 0){
			throw new IllegalArgumentException("Guard cannot be initialized with a non positive number");
		}
		numberPersons = thisNumberPersons;
	}
	
	//public method for getting the number of passengers that can be handled 
	public int getNumberPersons() {
		return numberPersons;
	}
	
	//public method for setting the number of passengers that can be handled 
	public int setNumberPersons(int howManyPeople) throws IllegalArgumentException {
		if(howManyPeople <= 0){
			throw new IllegalArgumentException("Guard cannot be modified with a non positive number");
		}
		numberPersons = howManyPeople;
		return numberPersons;

	}

	
	
}
