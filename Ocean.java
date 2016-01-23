package battleship;

import java.util.ArrayList;
import java.util.Random;

public class Ocean {
	
	private Ship[][] ships  = new Ship[10][10];  
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private boolean[][] firedButMissed = new boolean [10][10];
	private boolean[][] firedAndHit = new boolean [10][10];
	private boolean notOccquiped = false;
	private ArrayList<Ship> shipLocationsRandom = new ArrayList<Ship>();
	private ArrayList<Ship>  shipSpecificLocation = new ArrayList<Ship>();

	/**
	 * Constructor
	 */
	public Ocean() {
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		for(int i = 0; i < 10; i++){
			for(int j =0; j < 10; j++){
				this.ships[i][j]= new EmptySea();
				this.firedButMissed[i][j] = false;
				this.firedAndHit[i][j] = false;
			}
		}
		
	}
	
	/**
	 * helper function for the placeShipRandomly
	 * This function produces ten ships(one battleship, two cruiser, three destroyers and four submarines
	 * These ships will be added in a list used in the placeShipRandomly
	 * This function returns an array list
	 * @return
	 */
	public ArrayList<Ship> generateShips(){
		ArrayList<Ship> AllShips = new ArrayList<Ship>();
		
		AllShips.add(new Battleship());
		
		for(int i =0 ; i<2 ; i++){
			AllShips.add(new Cruiser());
		}
		
		for(int j =0 ; j <3 ; j++){
			AllShips.add(new Destroyer());
		}
		
		for(int k = 0; k<4; k++){
			AllShips.add(new Submarine());
		
		}
		return AllShips;
		
	}
	
	/**
	 * This function places all ship on the 10 x 10 array randomly 
	 * This function does not return anything
	 */
	public void placeAllShipsRandomly(){
		Random randomNumber = new Random();
		boolean notOccquiped = false;
		
		for(Ship ships : this.generateShips()){
			notOccquiped = false;
			while(notOccquiped == false){
				int row = randomNumber.nextInt(10);
				int column = randomNumber.nextInt(10);
				boolean horizontal = randomNumber.nextBoolean();
				notOccquiped = ships.okToPlaceShipAt(row, column, horizontal, this);
				if(notOccquiped == true){
					ships.placeShipAt(row, column, horizontal, this);
					this.shipLocationsRandom.add(ships);
				}
			}
		}
	}
	
	
	/**
	 * This function is specifically written for testing the program
	 * This function does not affect the program at all. It is just meant to test the program
	 * Given the row, column, direction of the ship and Ship Object,
	 * The function places a ship in the specific location
	 * This function returns an array list which is used in another test function called shootAt2
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ship
	 * @return
	 */
	public ArrayList<Ship> placeShipAtSpecificLoaction(int row, int column,boolean horizontal, Ship ship){
		
		if(ship.getShipType().equals("Submarine")){
			ship.placeShipAt(row, column, horizontal, this);
			this.shipSpecificLocation.add(ship);
		}
		if(ship.getShipType().equals("Destroyer")){
			ship.placeShipAt(row, column, horizontal, this);
			this.shipSpecificLocation.add(ship);
		}
		if(ship.getShipType().equals("Cruiser")){
			ship.placeShipAt(row, column, horizontal, this);
			this.shipSpecificLocation.add(ship);
		}
		if(ship.getShipType().equals("Battleship")){
			ship.placeShipAt(row, column, horizontal, this);
			this.shipSpecificLocation.add(ship);
		}
		return this.shipSpecificLocation;
	}
	
	/**
	 * This function checks whether the given location is occupied already
	 * This function returns a boolean
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isOccupied(int row, int column){
		if(this.ships[row][column] instanceof EmptySea){
			return false;
		}
		return true;
	}
	
	/**
	 * This function returns a 10 x 10 ship array
	 * @return
	 */
	public Ship [][] getShipArray(){
		return this.ships;
		
	}
	
	
	/**
	 * Given the row and column, the function shoots at the given location
	 * If the ship is hit, it will return true
	 * If the ship is not there, it will return false
	 * If the ship is sunk, it will also return false
	 * This function also counts fire shots and hits 
	 * This function also initiates fireAndHit array which is used to save the location for the ship that is shot
	 * This function also initiates firedButMissed array which is used to save the location that a shot is missed
	 * This function returns a boolean
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		boolean shipShots = false;
		boolean shipsSunk = false;
		this.shotsFired +=1;
		for(Ship ships : this.shipLocationsRandom){
			shipShots = ships.shootAt(row, column);
			if(shipShots == true){
				this.hitCount +=1;
				this.firedAndHit[row][column] = true;
				shipsSunk = ships.isSunk();
				if(shipsSunk == true){
					this.shipsSunk +=1;
					return false;
				}
				return true;
			}
		}
		this.firedButMissed[row][column] = true;
		return false;
	}
	
	/**
	 * The function is written for testing only
	 * It does not affect the function at all
	 *  Given the row and column, the function shoots at the given location
	 * If the ship is hit, it will return true
	 * If the ship is not there, it will return false
	 * If the ship is sunk, it will also return false
	 * This function also counts fire shots and hits 
	 * This function also initiates fireAndHit array which is used to save the location for the ship that is shot
	 * This function also initiates firedButMissed array which is used to save the location that a shot is missed
	 * This function returns a boolean
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt2(int row, int column){
		boolean shipShots = false;
		boolean shipsSunk = false;
		for(Ship ships : this.shipSpecificLocation){
			this.shotsFired +=1;
			shipShots = ships.shootAt(row, column);
			if(shipShots == true){
				this.hitCount +=1;
				this.firedAndHit[row][column] = true;
				shipsSunk = ships.isSunk();
				if(shipsSunk == true){
					this.shipsSunk +=1;
				}
				return true;
			}
		}
		this.firedButMissed[row][column] = true;
		return false;
	}
	
	
    /**
     * This function returns how many shots are fired
     * This function returns an integer
     * @return
     */
	public int getShotsFired(){
		return this.shotsFired;
	}
	
	
	/**
	 * This function returns hit counts
	 * This function returns an integer
	 * @return
	 */
	public int getHitCount(){
		return this.hitCount;
	}
	
	
    /*
     * This function returns how many ships are sunk
     * This function returns an integer
     */
	public int getShipsSunk(){
		return this.shipsSunk;
	}
	
	
	/**
	 * This function checks whether the game is over not not
	 * This function returns a boolean
	 * @return
	 */
	public boolean isGameOver(){
		if(this.getShipsSunk() == 10){
			return true;
		}
		return false;
	}
	
	/**
	 * The print() method prints out 10 x 10 array
	 * If you fired but missed, it will show " - " on the array
	 * If you fired and hit a ship, it will show " S " on the array
	 * If you sunk the ship, it will show " X " on the array
	 * If it is the empty sea, it will show " . "
	 * The main purpose of this function is to update the information for the player
	 * This function does not return anything
	 */
	public void print(){
		for(int i =0; i < 10 ; i++){
			System.out.print("  " + i +" ");
		}
		String hit = "";
		for(int row =0 ; row < 10 ; row++){
			System.out.print("\n\n" +row );
			for(int column =0; column < 10; column++){
				if(this.firedButMissed[row][column] == true){
					hit = "-";
				}
				else if(this.firedAndHit[row][column] == true){
					hit = this.ships[row][column].toString();
				}
				else{
					hit = new EmptySea().toString();
				}
				System.out.print(" " +hit + "  ");
			}
		}
	}

}
