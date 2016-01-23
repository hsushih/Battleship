package battleship;

public abstract class Ship {

	private int bowRow;
	private int bowColumn;
	protected int length;
	private boolean horizontal;
	protected boolean [] hit = new boolean [4];
	
    /**
     * return the length of the ship
     * @return
     */
	protected int getLength(){
		return this.length;
	}

	/**
	 * Constructor
	 */
	public Ship() {
	
	}

    
	/**
	 * return the bow row of the ship
	 * @return
	 */
	public int getBowRow(){
		return this.bowRow;
	}
    
	/**
	 * return the bow column of the ship
	 * @return
	 */
	public int getBowColumn(){
		return this.bowColumn;
	}
    
	/**
	 * return the direction of the ship( horizontal or vertical)
	 * @return
	 */
	public boolean isHorizontal(){
		return this.horizontal;
	}
    
	/**
	 * set the bow row for the ship
	 * @param row
	 */
	public void setBowRow(int row){
		this.bowRow = row;
	}
    
	
	/**
	 * set the bow column for the ship
	 * @param column
	 */
	public void setBowColumn(int column){
		this.bowColumn = column;
	}
    
	
	/**
	 * set the direction of the ship(horizontal or vertical)
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}
    
	
	abstract String getShipType();
	
	
	/**
	 * helper function for okToPlaceShipAt
	 * this helper function deals with the cases when the row or the column are equal to 9 or zero
	 * There are basically six cases in this function
	 * This function returns a boolean 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAtBoundaryLimit(int row, int column, boolean horizontal, Ocean ocean){
		Ship[][] shipArrays = ocean.getShipArray();
		int [] noShipsAllowed = {-1,0,1};
		int[] noShipsAllowed2 = {-1,0};
		int[] noShipsAllowed3 = {0,1};
		
		//Case 1 when row = 9 and column = 0
		if(row ==9 && column == 0){
			for(int numbers2 : noShipsAllowed2){
				for(int numbers : noShipsAllowed3){
					int rowNear = row + numbers2;
					int columnNear = column + numbers;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;
				}
				
				}
			}
			
		}
		// Case 2 when row = 0 and column =9
		else if( row ==0 && column == 9){
			for(int numbers2 : noShipsAllowed2){
				int columnNear = column + numbers2;
				if(!(shipArrays[row][columnNear] instanceof EmptySea)){
					return false;
				}
			}
		}
        
		// Case 3 when row = 9 and column !=0
		else if ( row == 9 && column !=0){
			for(int numbers2 : noShipsAllowed2){
				for(int numbers : noShipsAllowed){
					int rowNear = row + numbers2;
					int columnNear = column + numbers;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;

					}
				}
			}
		}
		
		// Case 4 when row = 0 and column !=9
		else if(column !=9 && row == 0){
			for(int numbers : noShipsAllowed3){
				for(int numbers2 : noShipsAllowed){
					int columnNear = column + numbers2;
					int rowNear = row + numbers;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;
					}

				}
			}
		}
		
		// Case 5 when the row !=9 and column = 0
		else if(column ==0 && row !=9){
			for(int numbers2 : noShipsAllowed){
				for(int numbers : noShipsAllowed3){
					int rowNear = row + numbers2;
					int columnNear = column + numbers;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;
				}
				
				}
			}
		}
		
		// Case 6 when row !=0 and column = 9
		else if ( column == 9 && row !=0){
			for(int numbers2 : noShipsAllowed2){
				for(int numbers : noShipsAllowed){
					int rowNear = row + numbers;
					int columnNear = column + numbers2;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;

					}
				}
			}
		}
		return true;
	}
    
	/**
	 * helper function for okToPlaceShipAt
	 * Basically, this function deals with the cases when row and column = 0 or 9
	 * This function returns a boolean
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAtBoundaryLimit2(int row, int column, boolean horizontal, Ocean ocean){
		Ship[][] shipArrays = ocean.getShipArray();
		int [] noShipsAllowedRow = {0,1};
		int [] noShipsAllowedColumn= {-1,0};
		
		// Case 1 when both row and column = 0
		if(row == 0 && column ==0){
			for(int numbers : noShipsAllowedRow){
				for(int numbers2 : noShipsAllowedRow){
					int rowNear = row + numbers ;
					int columnNear = column + numbers2;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;
					}
				}
			}

		}
		// Case2 when both row and column = 9
		if(row == 9 && column == 9){
			for(int numbers : noShipsAllowedColumn){
				for(int numbers2 : noShipsAllowedColumn){
					int rowNear = row + numbers ;
					int columnNear = column + numbers2;
					if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * helper function for okToPlaceShipAt
	 * This function just makes the function of okToPlaceShipAt much shorter(modularity)
	 * This function returns a boolean
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAtSupport(int row, int column, boolean horizontal, Ocean ocean){
		boolean okToPlaceShipBoundaryLimit = false;
		if(row ==0  && column == 0){
			if(okToPlaceShipBoundaryLimit == this.okToPlaceShipAtBoundaryLimit2(row, column, horizontal, ocean)){
				return false;
			}
		}
		else if(row == 9 && column == 9){
			if(okToPlaceShipBoundaryLimit == this.okToPlaceShipAtBoundaryLimit2(row, column, horizontal, ocean)){
				return false;
			}
		}
		else if(row == 0 || row ==9){
			if(okToPlaceShipBoundaryLimit == this.okToPlaceShipAtBoundaryLimit(row, column, horizontal, ocean)){
				return false;
			}
		}
		else if(column== 0 || column ==9){
			if(okToPlaceShipBoundaryLimit == this.okToPlaceShipAtBoundaryLimit(row, column, horizontal, ocean)){
				return false;
			}	
		}
		return true;
		
	}
    
	/**
	 * Given row, column , the direction of the ship and Ocean object, this function
	 * determines whether the ship overlaps or touches another ship (vertically, horizontally or diagonally)
	 * Also, if the ship is too long to fit in the given location, it should return false
	 * This function retruns a boolean
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		Ship[][] shipArrays = ocean.getShipArray();
		int [] noShipsAllowed = {-1,0,1};
		boolean okayToPlaceShip = false;
		
		// if the ship is horizontal
		
		if(horizontal == true){
			if(column + this.length > 10){      // see whether the ship is too long
				return false;
			}
			for(int i =1; i < this.length; i++){
				if(!(shipArrays[row][column+i] instanceof EmptySea)){    // check whether the surrounding areas are empty sea
					return false;
				}
			}
			if(row == 0 || column ==0 || row == 9 || column ==9){
				if(this.okToPlaceShipAtSupport(row, column, horizontal, ocean) == okayToPlaceShip){  // dealing with some tricky cases like row = 0 
					return false;                                                                    // row = 9, column = 0, column = 9
				}
			}
			
			else{                                             // make sure the ships don't overlap or touch another ships
				for(int numbers : noShipsAllowed){
					for(int numbers2 : noShipsAllowed){
						int rowNear = row + numbers ;
						int columnNear = column + numbers2;
						if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
							return false;
						}
					}
				}
			}
		}
		// The ship are vertical 
		if(this.horizontal == false){                       
			if(row + this.length > 10 ){             // see whether the ship is too long
				return false ;
			}
			for(int j =1 ; j < this.length ; j++){
				if(!(shipArrays[row+j][column] instanceof  EmptySea)){   // check whether the surrounding areas are empty sea
					return false;
				}
			}
			if(row == 0 || column ==0 || row == 9 || column ==9){
				if(this.okToPlaceShipAtSupport(row, column, horizontal, ocean) == okayToPlaceShip){  // dealing with some tricky cases like row = 0 
					return false;                                                                    // row =9, column = 0, column = 9
				}
			}
			else{
				for(int numbers : noShipsAllowed){                        //// make sure the ships don't overlap or touch another ships
					for(int numbers2 : noShipsAllowed){
						int rowNear = row + numbers ;
						int columnNear = column + numbers2;
						if(!(shipArrays[rowNear][columnNear] instanceof EmptySea)){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Given row, column, the direction of the ship and Object Ocean, the fucntion places a ship on the 10x10 array
	 * This function also sets the row, column and the direction  of the ship
	 * It returns nothing
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean ){
		Ship[][] ShipArrays = ocean.getShipArray();
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);

		if(horizontal == true){
			for(int i =0; i < this.length; i++){
				ShipArrays[row][column+i] = this;
			}
		}
		else{
			for(int i =0; i < this.length; i++){
				ShipArrays[row +i][column] = this;
			}
		}
	}
	
	
	/**
	 * Given row and column, the function shoots the coordinate given
	 * If the given location is empty sea, it will return false
	 * If you shoot the part of the ship, it will return true
	 * If you shoot a sunk ship, it will return false
	 * This function also turns hit array to true
	 * This function returns a boolean
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean shootAt(int row, int column){
		Ocean ocean = new Ocean();
		if(this.isSunk() == true){
			return false;
		}
		
		else if(ocean.getShipArray()[row][column].equals( new EmptySea())){
			return false;
		}
		
		else if(this.horizontal == true){
			if(this.bowRow == row){
				for(int i =0; i < this.length ; i++){
					if(this.bowColumn + i == column){
						this.hit[i] = true;
					    return true;
					}
				}
			}
		}
		else if (this.horizontal == false){
			if(this.bowColumn == column){
				for(int i =0 ; i<this.length ; i++){
					if(this.bowRow + i == row){
						this.hit[i] = true;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * This function determines whether the ship is sunk or not
	 * If the ship is sunk, it will return true; otherwise, it will return false
	 * This function returns a boolean
	 * @return
	 */
	public boolean isSunk(){
		for(boolean hit : this.hit){
			if( hit == false){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ToString function
	 * If the ship is sunk, it will return X. 
	 * If the ship is afloat and you hit the part of the ship, it will return S
	 */
	@Override
	public String toString(){
		if(this.isSunk() == true){
			return "X";
		}
		return "S";
	}			
}
