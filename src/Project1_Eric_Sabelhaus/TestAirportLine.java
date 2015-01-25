package Project1_Eric_Sabelhaus;

public class TestAirportLine {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//instantiate guards
		SecurityGuard guard1 = new SecurityGuard(1);
		SecurityGuard guard2 = new SecurityGuard(2);
		SecurityGuard guard3 = new SecurityGuard(2);
		SecurityGuard guard4 = new SecurityGuard(3);
		SecurityGuard guard5 = new SecurityGuard(3);

		//instantiate line
		SecurityLine line = new SecurityLine();
		
		//wrap thread sleep attempt in try catch statement for thread safety purposes
		try {
			//while people remain in the line, continue to process them
			for(int minutes = 0; minutes < 10; minutes++){
				//print the contents of the line
				System.out.println(line.toS());
				//process people through guard 1
				line.removePeople(guard1.getNumberPersons());
				//process people through guard 2
				line.removePeople(guard2.getNumberPersons());
				//process people through guard 3
				line.removePeople(guard3.getNumberPersons());
				//process people through guard 4
				line.removePeople(guard4.getNumberPersons());
				//process people through guard 5
				line.removePeople(guard5.getNumberPersons());
				//its been 60 seconds, add 10 more people to the line
				line.addPeople(10);
				//print the line after a minute
				System.out.println(line.toS());
				System.out.println("It has been: " + (minutes + 1) + " minutes.");
				//put our thread to sleep for 60 seconds before iterating over the queue again.
				Thread.sleep(60000);
			}
		} catch (InterruptedException e) {
			//print stack if exception occurs during runtime
			e.printStackTrace();
		}
	}

}
