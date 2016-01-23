package battleship;

public class Submarine extends Ship {
	
   /*
    * Constructor
    */
	public Submarine() {
		this.length = 1;
		this.hit = new boolean [1];
		
	}
    
	/*
	 *  It just returns "Submarine"
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "Submarine";
	}

}
