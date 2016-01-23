package battleship;

public class Destroyer extends Ship {
	
    /**
     * Constructor
     */
	public Destroyer() {
		this.length = 2;
	    this.hit = new boolean [2];
	}
    
	/*
	 * It just returns "Destroyer"
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "Destroyer";
	}

}
