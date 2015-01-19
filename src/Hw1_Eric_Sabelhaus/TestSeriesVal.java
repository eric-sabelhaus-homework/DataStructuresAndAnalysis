package Hw1_Eric_Sabelhaus;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestSeriesVal {
	
	@Test
	public void testRecurseAndIterate() {
		RecursionGui gui = new RecursionGui();
		double one   = gui.seriesIter(1000);
		double two   = gui.seriesIter(100);
		double three = gui.seriesIter(10);
		double four  = gui.seriesRec(10, 1);
		double five   = gui.seriesRec(100, 1);
		double six = gui.seriesRec(1000, 1);
		
		double expectOne     = 1.4999999999999998;
		double expectTwo     = 1.4999999999999998;
		double expectThree	 = 1.4990234375;
		double expectFour	 = 1.4990234375;
		double expectFive	 = 1.4999999999999998;
		double expectSix   = 1.4999999999999998;
		
		assertEquals(one, expectOne, 0);
		assertEquals(two, expectTwo, 0);
		assertEquals(three, expectThree, 0);
		assertEquals(four, expectFour, 0);
		assertEquals(five, expectFive, 0);
		assertEquals(six, expectSix, 0);
	}

}
