package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {
	private Destroyer destroyer;
	private Ocean ocean;
    
	@Before
	public void setUp() throws Exception {
		destroyer = new Destroyer();
		ocean = new Ocean();
	}

	@Test
	public void testGetShipType() {
		assertEquals(destroyer.getShipType(),"Destroyer");
	}

	@Test
	public void testDestroyer() {
		assertEquals(destroyer.getLength(),2);
		for(int i =0 ; i < destroyer.hit.length ; i++){
			destroyer.hit[i] = false;
		}
		destroyer.placeShipAt(9, 5, true, ocean);
		destroyer.shootAt(9, 5);
		destroyer.shootAt(9, 6);
		for(int i =0 ; i < destroyer.hit.length ; i++){
			assertTrue(destroyer.hit[i] = true);
	    }
	}

}
