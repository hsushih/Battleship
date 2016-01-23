package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptySeaTest {
	private EmptySea emptysea;
	private Ocean ocean;

	@Before
	public void setUp() throws Exception {
		emptysea = new EmptySea();
		ocean = new Ocean();
	}

	@Test
	public void testGetShipType() {
		assertEquals(emptysea.getShipType(),"empty");
	}

	@Test
	public void testShootAt() {
		assertFalse(emptysea.shootAt(0, 0));
		assertFalse(emptysea.shootAt(9, 9));
	}

	@Test
	public void testIsSunk() {
		assertFalse(emptysea.isSunk());
	}

	@Test
	public void testToString() {
		for(int i = 0; i < 10; i++){
			for(int j =0; j < 10; j++){
				assertEquals(this.ocean.getShipArray()[i][j].toString(),".");
			}
		}
		assertEquals(emptysea.toString(),".");
	}

	@Test
	public void testEmptySea() {
		assertEquals(emptysea.getLength(),1);
	}

}
