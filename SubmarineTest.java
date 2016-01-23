package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubmarineTest {
	
	private Submarine submarine;
	private Ocean ocean;

	@Before
	public void setUp() throws Exception {
		
		submarine = new Submarine();
		ocean = new Ocean();
	}
	

	@Test
	public void testGetShipType() {
		assertEquals(submarine.getShipType(),"Submariner");
	}

	@Test
	public void testSubmarine() {
		assertEquals(submarine.getLength(),1);
		for(int i =0 ; i < submarine.hit.length ; i++){
			submarine.hit[i] = false;
		}
		submarine.placeShipAt(9, 5, true, ocean);
		submarine.shootAt(9, 5);
		for(int i =0 ; i < submarine.hit.length ; i++){
			assertTrue(submarine.hit[i] = true);
	    }
	}

}
