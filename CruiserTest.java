package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CruiserTest {
	
	private Cruiser cruiser;
	private Ocean ocean;

	@Before
	public void setUp() throws Exception {
		cruiser = new Cruiser();
		ocean = new Ocean();
	}

	@Test
	public void testGetShipType() {
		assertEquals(cruiser.getShipType(),"Cruiser");
	}

	@Test
	public void testCruiser() {
		assertEquals(cruiser.getLength(),3);
		for(int i =0 ; i < cruiser.hit.length ; i++){
			cruiser.hit[i] = false;
		}
		cruiser.placeShipAt(9, 5, true, ocean);
		cruiser.shootAt(9, 5);
		cruiser.shootAt(9, 6);
		cruiser.shootAt(9, 7);
		for(int i =0 ; i < cruiser.hit.length ; i++){
			assertTrue(cruiser.hit[i] = true);
	    }
	}

}
