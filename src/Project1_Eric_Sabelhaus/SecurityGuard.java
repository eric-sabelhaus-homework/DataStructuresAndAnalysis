package Project1_Eric_Sabelhaus;

public class SecurityGuard {

	private int numberPersons;
	
	SecurityGuard(int thisNumberPersons) {
		numberPersons = thisNumberPersons;
	}
	
	public int getNumberPersons() {
		return numberPersons;
	}
	
	public int setNumberPersons(int howManyPeople) {
		numberPersons = howManyPeople;
		return numberPersons;
	}
	
}
