package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	
	private Ocean ocean;
	private Ship submarine;
	private Ship destroyer;
	private Ship cruiser;
	private Ship battleship;

	@Before
	public void setUp() throws Exception {
		
		ocean = new Ocean();
		submarine = new Submarine();
		destroyer = new Destroyer();
		cruiser = new Cruiser();
		battleship = new Battleship();
	}

	@Test
	public void testOcean() {
		assertEquals(ocean.getShotsFired(),0);
		assertEquals(ocean.getShipsSunk(),0);
		assertEquals(ocean.getHitCount(),0);
		for(int i = 0; i < 10; i++){
			for(int j =0; j < 10; j++){
				assertEquals(ocean.getShipArray()[i][j].getShipType(),"empty");
			}
		}
		
	}

	@Test
	public void testGenerateShips() {
		// put ten ships in an array list
		assertEquals(ocean.generateShips().size(),10);
		
		// the first ship is battleship
		assertEquals(ocean.generateShips().get(0).length,4);
		assertEquals(ocean.generateShips().get(0).getShipType(),"Battleship");
		// the second and the third ship are cruisers
		assertEquals(ocean.generateShips().get(1).length,3);
		assertEquals(ocean.generateShips().get(1).getShipType(),"Cruiser");
		assertEquals(ocean.generateShips().get(2).length,3);
		assertEquals(ocean.generateShips().get(2).getShipType(),"Cruiser");
		// The fourth, fifth and sixth are destroyers 
		assertEquals(ocean.generateShips().get(3).length,2);
		assertEquals(ocean.generateShips().get(3).getShipType(),"Destroyer");
		assertEquals(ocean.generateShips().get(4).length,2);
		assertEquals(ocean.generateShips().get(4).getShipType(),"Destroyer");
		assertEquals(ocean.generateShips().get(5).length,2);
		assertEquals(ocean.generateShips().get(5).getShipType(),"Destroyer");
		// the seventh, eight and ninth and tenth are submarines 
		assertEquals(ocean.generateShips().get(6).length,1);
		assertEquals(ocean.generateShips().get(6).getShipType(),"Submarine");
		assertEquals(ocean.generateShips().get(7).length,1);
		assertEquals(ocean.generateShips().get(7).getShipType(),"Submarine");
		assertEquals(ocean.generateShips().get(8).length,1);
		assertEquals(ocean.generateShips().get(8).getShipType(),"Submarine");
		assertEquals(ocean.generateShips().get(9).length,1);
		assertEquals(ocean.generateShips().get(9).getShipType(),"Submarine");
	}


	@Test
	public void testPlaceShipAtSpecificLoaction() {
		// place a submarine;
		ocean.placeShipAtSpecificLoaction(5, 5, true, submarine);
		assertTrue(ocean.isOccupied(5, 5));
		assertFalse(ocean.isOccupied(5, 4));
		
		
		// place a destroyer
		ocean.placeShipAtSpecificLoaction(0, 0, true, destroyer);
		assertTrue(ocean.isOccupied(0, 0));
		assertTrue(ocean.isOccupied(0, 1));
		assertFalse(ocean.isOccupied(0, 2));
		
		// place a cruiser 
		ocean.placeShipAtSpecificLoaction(7, 5, false, cruiser);
		assertFalse(ocean.isOccupied(6, 5));
		assertTrue(ocean.isOccupied(7, 5));
		assertTrue(ocean.isOccupied(8, 5));
		assertTrue(ocean.isOccupied(9, 5));
		
		// place a battleship
		ocean.placeShipAtSpecificLoaction(2, 3, false, battleship);
		assertFalse(ocean.isOccupied(1, 3));
		assertTrue(ocean.isOccupied(2, 3));
		assertTrue(ocean.isOccupied(3, 3));
		assertTrue(ocean.isOccupied(4, 3));
		assertTrue(ocean.isOccupied(5, 3));
		
	}

	@Test
	public void testIsOccupied() {
		// place a submarine;
		ocean.placeShipAtSpecificLoaction(5, 5, true, submarine);
		assertTrue(ocean.isOccupied(5, 5));
		assertFalse(ocean.isOccupied(5, 4));

		// place a destroyer
		ocean.placeShipAtSpecificLoaction(0, 0, true, destroyer);
		assertTrue(ocean.isOccupied(0, 0));
		assertTrue(ocean.isOccupied(0, 1));
		assertFalse(ocean.isOccupied(0, 2));

		// place a cruiser 
		ocean.placeShipAtSpecificLoaction(7, 5, false, cruiser);
		assertFalse(ocean.isOccupied(6, 5));
		assertTrue(ocean.isOccupied(7, 5));
		assertTrue(ocean.isOccupied(8, 5));
		assertTrue(ocean.isOccupied(9, 5));

		// place a battleship
		ocean.placeShipAtSpecificLoaction(2, 3, false, battleship);
		assertFalse(ocean.isOccupied(1, 3));
		assertTrue(ocean.isOccupied(2, 3));
		assertTrue(ocean.isOccupied(3, 3));
		assertTrue(ocean.isOccupied(4, 3));
		assertTrue(ocean.isOccupied(5, 3));
	}

	@Test
	public void testGetShipArray() {
		for(int i = 0; i < 10; i++){
			for(int j =0; j < 10; j++){
				assertEquals(ocean.getShipArray()[i][j].getShipType(),"empty");
			}
		}
		// place a submarine at 0,0
		ocean.placeShipAtSpecificLoaction(0, 0, true, submarine);
		assertEquals(ocean.getShipArray()[0][0].getShipType(),"Submarine");
		// place a battleship at 5,5
		ocean.placeShipAtSpecificLoaction(5, 5, true, battleship);
		assertEquals(ocean.getShipArray()[5][5].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[5][6].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[5][7].getShipType(),"Battleship");
		assertEquals(ocean.getShipArray()[5][8].getShipType(),"Battleship");
	}

	
    // Since my shootAt function is based on the placeShipsRandomly, I can't test it but I wrote 
	// an extremely similar function which is ShootAt2. The only difference between shootAt
	// and ShootAt2 is that ShootAt is based on a random ship list which I can't manipulate
	// the locations of the ship. However, ShootAt 2 is based on a specific ship with a specific
	// location which I can test it 
	@Test
	public void testShootAt2() {
		ocean.placeShipAtSpecificLoaction(0, 0, true, submarine);
		assertTrue(ocean.shootAt2(0, 0));
		// the ship is sunk 
		assertFalse(ocean.shootAt2(0, 0));
		// place a battleship
		ocean.placeShipAtSpecificLoaction(5, 5, true, battleship);
		assertTrue(ocean.shootAt2(5, 5));
		assertTrue(ocean.shootAt2(5, 6));
		assertTrue(ocean.shootAt2(5, 7));
		assertTrue(ocean.shootAt2(5, 8));
		// the ship is sunk
		assertFalse(ocean.shootAt2(5, 5));
		assertFalse(ocean.shootAt2(5, 6));
		assertFalse(ocean.shootAt2(5, 7));
		assertFalse(ocean.shootAt2(5, 8));
		// shoot the empty sea
		assertFalse(ocean.shootAt2(5, 9));
		assertFalse(ocean.shootAt2(6, 0));
	}

	@Test
	public void testGetShotsFired() {
		assertEquals(ocean.getShotsFired(),0);
		// fire a shot
		ocean.shootAt(0, 0);
		assertEquals(ocean.getShotsFired(),1);
		ocean.shootAt(0, 0);
		assertEquals(ocean.getShotsFired(),2);
	}

	@Test
	public void testGetHitCount() {
		// initial hit count is zero
		assertEquals(ocean.getHitCount(),0);
		// hit one ship
		ocean.placeShipAtSpecificLoaction(0, 0, true, submarine);
		ocean.shootAt2(0, 0);
		assertEquals(ocean.getHitCount(),1);
		ocean.shootAt2(0, 0);
		// the ship is in the bottom of the sea
		assertEquals(ocean.getHitCount(),1);
		// shoot at the empty sea
		ocean.shootAt2(0, 1);
		ocean.shootAt2(0, 2);
		assertEquals(ocean.getHitCount(),1);
		// place a battleship and shoot it
		ocean.placeShipAtSpecificLoaction(9, 5, true, battleship);
		ocean.shootAt2(9, 5);
		ocean.shootAt2(9, 6);
		ocean.shootAt2(9, 7);
		ocean.shootAt2(9, 8);
		assertEquals(ocean.getHitCount(),5);
		// the ship is sunk
		ocean.shootAt2(9, 5);
		ocean.shootAt2(9, 6);
		ocean.shootAt2(9, 7);
		ocean.shootAt2(9, 8);
		assertEquals(ocean.getHitCount(),5);
		
	}

	@Test
	public void testGetShipsSunk() {
		// no sunk ships currently
		assertEquals(ocean.getShipsSunk(),0);
		// place a submarine
		ocean.placeShipAtSpecificLoaction(0, 0, true, submarine);
		ocean.shootAt2(0, 0);
		assertEquals(ocean.getShipsSunk(),1);
		// place a battleship
		ocean.placeShipAtSpecificLoaction(9, 5, true, battleship);
		ocean.shootAt2(9, 5);
		ocean.shootAt2(9, 6);
		ocean.shootAt2(9, 7);
		ocean.shootAt2(9, 8);
		assertEquals(ocean.getShipsSunk(),2);
	}

	@Test
	public void testIsGameOver() {
		assertFalse(ocean.isGameOver());
		ocean.placeAllShipsRandomly();
		for(int i = 0; i < 10; i++){
			for(int j =0; j < 10; j++){
				ocean.shootAt(i, j);
			}
		}
		assertTrue(ocean.isGameOver());
		
		
	}

}
