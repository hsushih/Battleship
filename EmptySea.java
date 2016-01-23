package battleship;

public class EmptySea extends Ship {
	
	/*
	 * Constructor
	 */
	public EmptySea() {
		this.length = 1;
	}
	
	/*
	 * It just returns false
	 * @see battleship.Ship#shootAt(int, int)
	 */
	@Override
	public boolean shootAt(int row, int column){
		return false;
	}
	
	/*
	 * It just returns false
	 * @see battleship.Ship#isSunk()
	 */
	@Override
	public boolean isSunk(){
		return false;
	}
	
	/*
	 * It just returns " . "
	 * @see battleship.Ship#toString()
	 */
	@Override
	public String toString(){
		return ".";
	}
    
	/*
	 * It just returns empty
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	String getShipType() {
		return "empty";
	}

}
