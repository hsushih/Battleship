package battleship;

public class Cruiser extends Ship{
	
	
    /*
     * Constructor
     */
	public Cruiser() {
		this.length = 3;
		this.hit = new boolean [3];
	}
	
	/*
	 * It just returns "Cruiser"
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "Cruiser";
	}

}
