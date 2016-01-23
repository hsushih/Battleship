package battleship;

public class Battleship extends Ship {
	
	private boolean [] hit = new boolean [4];
    
	/**
	 * Constructor
	 */
	public Battleship() {
		this.length = 4;
		this.hit = new boolean[4];
	}
    
	/**
	 * It just returns "Battleship"
	 */
	@Override
	public String getShipType() {
		return "Battleship";
	}

}
