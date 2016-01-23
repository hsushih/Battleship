package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {
	
	private Ship battleship;
	private Ship cruiser;
	private Ship destroyer;
	private Ship submarine;
	private Ocean ocean;

	@Before
	public void setUp() throws Exception {
		battleship = new Battleship();
		cruiser = new Cruiser();
		destroyer = new Destroyer();
		submarine = new Submarine();
		ocean = new Ocean();
	}

	@Test
	public void testGetLength() {
		assertEquals(battleship.getLength(), 4);
		assertEquals(cruiser.getLength(), 3);
		assertEquals(destroyer.getLength(), 2);
		assertEquals(submarine.getLength(), 1);
	}

	@Test
	public void testGetBowRow() {
		// place at bow zero
		battleship.placeShipAt(0, 0, true, ocean);
		assertEquals(battleship.getBowRow(),0);
		//place at bow 5
		cruiser.placeShipAt(5, 4, true, ocean);
		assertEquals(cruiser.getBowRow(),5);
		// place at bow 9
		submarine.placeShipAt(9, 9, true, ocean);
		assertEquals(submarine.getBowRow(),9);
	}

	@Test
	public void testGetBowColumn() {
		// place at column zero
		battleship.placeShipAt(0, 0, true, ocean);
		assertEquals(battleship.getBowColumn(),0);
		//place at column 5
		cruiser.placeShipAt(5, 4, true, ocean);
		assertEquals(cruiser.getBowColumn(),4);
		// place at column 9
		submarine.placeShipAt(9, 9, true, ocean);
		assertEquals(submarine.getBowColumn(),9);
	}

	@Test
	public void testIsHorizontal() {
		// horizontal battleship
		battleship.placeShipAt(0, 0, true, ocean);
		assertTrue(battleship.isHorizontal());
		//vertical cruiser
		cruiser.placeShipAt(5, 4, false, ocean);
		assertFalse(cruiser.isHorizontal());
		// horizontal submarine
		submarine.placeShipAt(9, 9, true, ocean);
		assertTrue(submarine.isHorizontal());
	}

	@Test
	public void testSetBowRow() {
		// battleship at row 0
		battleship.setBowRow(0);
		assertEquals(battleship.getBowRow(),0);
		// cruiser at row 5
		cruiser.setBowRow(5);
		assertEquals(cruiser.getBowRow(),5);
		// submarine at row 9
		submarine.setBowRow(9);
		assertEquals(submarine.getBowRow(),9);
	}

	@Test
	public void testSetBowColumn() {
		// battleship at column 0
		battleship.setBowColumn(0);
		assertEquals(battleship.getBowColumn(),0);
		// cruiser at column 5
		cruiser.setBowColumn(5);
		assertEquals(cruiser.getBowColumn(),5);
		// submarine at column 9
		submarine.setBowColumn(9);
		assertEquals(submarine.getBowColumn(),9);
	}

	@Test
	public void testSetHorizontal() {
		// horizontal battleship
		battleship.setHorizontal(true);
		assertTrue(battleship.isHorizontal());
		//vertical cruiser
		cruiser.setHorizontal(false);
		assertFalse(cruiser.isHorizontal());
		// horizontal submarine
		submarine.setHorizontal(true);
		assertTrue(submarine.isHorizontal());
	}

	@Test
	public void testGetShipType() {
		assertEquals(battleship.getShipType(), "Battleship");
		assertEquals(cruiser.getShipType(), "Cruiser");
		assertEquals(destroyer.getShipType(), "Destroyer");
		assertEquals(submarine.getShipType(), "Submarine");
	}
    

	@Test
	public void testOkToPlaceShipAtBoundaryLimit() {
		// place a submarine at 9 , 1
		submarine.placeShipAt(9, 1, true, ocean);
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 0, true, ocean));  // case 1 in the function
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 1, true, ocean));  // case 3 in the function
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(8, 0, true, ocean));  // case 5 in the function
		assertFalse(submarine.okToPlaceShipAt(8, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(9, 2, true, ocean));
		// place a submarine at 0 , 8
		submarine.placeShipAt(0, 8, true, ocean);
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 9, true, ocean)); // case 2 in the function
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 7, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 8, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAt(1, 7, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(1, 8, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(1, 9, true, ocean)); // case 6 in the function
		// place a battleship at 1,1
		battleship.placeShipAt(1, 1, false, ocean);
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit2(0, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(1, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(2, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(3, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(4, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(5, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 1, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 2, true, ocean)); 
		
	}

	@Test
	public void testOkToPlaceShipAtBoundaryLimit2() {
		// place a battleship at 1,1
		battleship.placeShipAt(1, 1, false, ocean);
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit2(0, 0, true, ocean)); //case 1 in the function
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(0, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(1, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(2, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(3, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(4, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(5, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 1, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 2, true, ocean)); 
		assertTrue(submarine.okToPlaceShipAtBoundaryLimit(0, 3, true, ocean)); // it is allowed to place a ship here
		assertTrue(submarine.okToPlaceShipAtBoundaryLimit(0, 4, true, ocean)); // it is allowed to place a ship here
		// place a battleship at 9 ,5
		battleship.placeShipAt(9, 5, true, ocean);
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit2(9, 9, true, ocean)); // case 2 in the function 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 4, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 5, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 6, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 7, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(9, 8, true, ocean));
		assertFalse(submarine.okToPlaceShipAtBoundaryLimit(8, 9, true, ocean));
		assertTrue(submarine.okToPlaceShipAtBoundaryLimit(7, 9, true, ocean)); // it is allowed to place a ship here
		assertTrue(submarine.okToPlaceShipAtBoundaryLimit(6, 9, true, ocean)); // it is allowed to place a ship here
		assertFalse(submarine.okToPlaceShipAt(8, 4, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 5, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 6, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 7, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 8, true, ocean));

	}

	@Test
	public void testOkToPlaceShipAtSupport() {
		// place a battleship at 1,1
		battleship.placeShipAt(1, 1, false, ocean);
		assertFalse(submarine.okToPlaceShipAtSupport(0, 0, true, ocean)); // case 1 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(0, 1, true, ocean)); // case 3 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(0, 2, true, ocean)); // case 3 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(1, 0, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(2, 0, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(3, 0, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(4, 0, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAtSupport(5, 0, true, ocean)); // case 4 in the function
		assertFalse(submarine.okToPlaceShipAt(5, 1, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 2, true, ocean)); 
		// place a battleship at 9 ,5
		battleship.placeShipAt(9, 5, true, ocean);
		assertFalse(submarine.okToPlaceShipAtSupport(9, 9, true, ocean)); // case 2 in the function 
		assertFalse(submarine.okToPlaceShipAtSupport(9, 4, true, ocean)); // case 3 in the function 
		assertFalse(submarine.okToPlaceShipAtSupport(9, 5, true, ocean)); // case 3 in the function 
		assertFalse(submarine.okToPlaceShipAtSupport(9, 6, true, ocean)); // case 3 in the function 
		assertFalse(submarine.okToPlaceShipAtSupport(9, 7, true, ocean)); // case 3 in the function 
		assertFalse(submarine.okToPlaceShipAtSupport(9, 8, true, ocean)); // case 3 in the function 
		assertFalse(submarine.okToPlaceShipAtSupport(8, 9, true, ocean)); // case 4 in the function 
		assertTrue(submarine.okToPlaceShipAtSupport(7, 9, true, ocean)); // it is allowed to place a ship here
		assertTrue(submarine.okToPlaceShipAtSupport(6, 9, true, ocean)); // it is allowed to place a ship here
		assertFalse(submarine.okToPlaceShipAt(8, 4, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 5, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 6, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 7, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 8, true, ocean));
	}
//
	@Test
	public void testOkToPlaceShipAt() {
		// test to see if the ship is too long
		assertFalse(battleship.okToPlaceShipAt(7, 7, true, ocean));
		assertFalse(cruiser.okToPlaceShipAt(8,5, false, ocean));
		// ship fits in the array
		assertTrue(battleship.okToPlaceShipAt(3, 5, true, ocean));
		
		// place a submarine at 9 , 1
		submarine.placeShipAt(9, 1, true, ocean);
		assertFalse(submarine.okToPlaceShipAt(9, 0, true, ocean));  
		assertFalse(submarine.okToPlaceShipAt(9, 1, true, ocean));  
		assertFalse(submarine.okToPlaceShipAt(8, 0, true, ocean));  
		assertFalse(submarine.okToPlaceShipAt(8, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(8, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(9, 2, true, ocean));
		// place a submarine at 0 , 8
		submarine.placeShipAt(0, 8, true, ocean);
		assertFalse(submarine.okToPlaceShipAt(0, 9, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(0, 7, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(0, 8, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(1, 7, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(1, 8, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(1, 9, true, ocean)); 
		// place a battleship at 1,1
		battleship.placeShipAt(1, 1, false, ocean);
		assertFalse(submarine.okToPlaceShipAt(0, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(0, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(0, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(1, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(2, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(3, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(4, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 0, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 1, true, ocean)); 
		assertFalse(submarine.okToPlaceShipAt(5, 2, true, ocean)); 
	}

	@Test
	public void testPlaceShipAt() {
		// place a battle ship at 1,1
		assertTrue(ocean.getShipArray()[1][1] instanceof EmptySea); // before placing a ship
		battleship.placeShipAt(1, 1, true, ocean);
		assertFalse(ocean.getShipArray()[1][1] instanceof EmptySea); // after placing a ship
		assertFalse(ocean.getShipArray()[1][2] instanceof EmptySea);
		assertFalse(ocean.getShipArray()[1][3] instanceof EmptySea);
		assertFalse(ocean.getShipArray()[1][4] instanceof EmptySea);
		assertTrue(ocean.getShipArray()[1][5] instanceof EmptySea);  // empty sea
		// place a ship at 0,0
		assertTrue(ocean.getShipArray()[0][0] instanceof EmptySea);  // before placing a ship
		submarine.placeShipAt(0, 0, true, ocean);
		assertFalse(ocean.getShipArray()[0][0] instanceof EmptySea); // after placing a ship
		// place a ship at 9,9
		assertTrue(ocean.getShipArray()[9][9] instanceof EmptySea);  // before placing a ship
		submarine.placeShipAt(9, 9, true, ocean);
		assertFalse(ocean.getShipArray()[9][9] instanceof EmptySea); // after placing a ship
	}

	@Test
	public void testShootAt() {
		// empty sea
		assertTrue(ocean.getShipArray()[0][0] instanceof EmptySea);  // before placing a ship
		assertFalse(ocean.getShipArray()[0][0].shootAt(0, 0));
		
		// before placing a ship
		assertFalse(submarine.shootAt(0, 1));
		// after placing a ship
		submarine.placeShipAt(0, 5, true, ocean);
		assertTrue(submarine.shootAt(0, 5));
		// the ship is sunk
		assertFalse(submarine.shootAt(0, 5));
		
		// before placing a battle ship
		assertFalse(battleship.shootAt(9, 5));
		assertFalse(battleship.shootAt(9, 6));
		assertFalse(battleship.shootAt(9, 7));
		assertFalse(battleship.shootAt(9, 8));
		// after placeing a battle ship
		battleship.placeShipAt(9, 5, true, ocean);
		assertTrue(battleship.shootAt(9, 5));
		assertTrue(battleship.shootAt(9, 6));
		assertTrue(battleship.shootAt(9, 7));
		assertTrue(battleship.shootAt(9, 8));
		// the ship is sunk
		assertFalse(battleship.shootAt(9, 5));
		assertFalse(battleship.shootAt(9, 6));
		assertFalse(battleship.shootAt(9, 7));
		assertFalse(battleship.shootAt(9, 8));
		
	}

	@Test
	public void testIsSunk() {
		battleship.placeShipAt(9, 5, true, ocean);
		// the ship is still afloat
		assertFalse(battleship.isSunk());
		// the ship is still afloat after three shots
		battleship.shootAt(9, 5);
		battleship.shootAt(9, 6);
		battleship.shootAt(9, 7);
		assertFalse(battleship.isSunk());
		// the ship is sunk
		battleship.shootAt(9, 8);
		assertTrue(battleship.isSunk());
		
		// place a cruiser vertically
		cruiser.placeShipAt(5, 4, false, ocean);
		assertFalse(cruiser.isSunk());
		// the ship is still afloat after two shots
		cruiser.shootAt(5, 4);
		cruiser.shootAt(6, 4);
		assertFalse(cruiser.isSunk());
		// the ship is sunk
		cruiser.shootAt(7, 4);
		assertTrue(cruiser.isSunk());
	}

	@Test
	public void testToString() {
		// place a cruiser vertically
		cruiser.placeShipAt(5, 4, false, ocean);
		// the ship is still afloat after two shots
		cruiser.shootAt(5, 4);
		cruiser.shootAt(6, 4);
		assertEquals(cruiser.toString(),"S");
		// the ship is sunk
		cruiser.shootAt(7, 4);
		assertEquals(cruiser.toString(),"X");
	}

}
