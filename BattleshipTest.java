package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BattleshipTest {
	
	private Ship battleship;
	private Ocean ocean;

	@Before
	public void setUp() throws Exception {
		battleship = new Battleship();
		ocean = new Ocean();
	}

	@Test
	public void testGetShipType() {
		assertEquals(battleship.getShipType(),"Battleship");
	}

	@Test
	public void testBattleship() {
		assertEquals(battleship.getLength(),4);
		for(int i =0 ; i < battleship.hit.length ; i++){
			battleship.hit[i] = false;
		}
		battleship.placeShipAt(9, 5, true, ocean);
		battleship.shootAt(9, 5);
		battleship.shootAt(9, 6);
		battleship.shootAt(9, 7);
		battleship.shootAt(9, 8);
		for(int i =0 ; i < battleship.hit.length ; i++){
			assertTrue(battleship.hit[i] = true);
	    }
	}

}
