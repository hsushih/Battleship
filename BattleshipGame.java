package battleship;

import java.util.Scanner;

public class BattleshipGame {
	
	private Ocean ocean;
    
	
	/*
	 * Constructor
	 */
	public BattleshipGame() {
		
	}
    
	/*
	 * The main function of the Battleship Game
	 */
	public static void main(String[] args) {
		new BattleshipGame ().playGame();
		

	}
	
	/*
	 * This function asks user some inputs and start the game automatically
	 * If all the ships are sunk in the end, it will show how many shots you used and 
	 * kindly ask you if you to play again
	 */
	public void  playGame(){
		this.ocean = new Ocean();
		this.ocean.placeAllShipsRandomly();
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		while(this.ocean.isGameOver() == false){
			this.ocean.print();
			System.out.println("\nPlease enter the position you want to shoot the ship");
			String [] location = input.nextLine().split(",");
			
			if(location.length <= 1 || location.length > 2){
				System.out.println("invalid input");
				continue;
			}
			
			int row = Integer.parseInt(location[0]);
			int column = Integer.parseInt(location[1]);
			
			if( row > 9 || row <0 || column > 9 || column <0){
				System.out.println("invlaid input");
				continue;
			}
			
			this.ocean.shootAt(row, column);
			System.out.println("you have fired " + this.ocean.getShotsFired()+ "\n");
			System.out.println("you have sunk " + this.ocean.getShipsSunk()+ " ships" + "\n");
			if(this.ocean.isGameOver() == true){
				System.out.println("Congrats!!! You have sunk all the ships\n");
				System.out.println("Let's see how many shots you have fired\n");
				System.out.println("you have fired " + this.ocean.getShotsFired()+"\n");
				System.out.println("Do you wanna play a again  y/n \n");
				String continueGame =input2.nextLine();
				continueGame.toLowerCase();
				if(continueGame.equals("y")){
					this.ContinueGame();
				}
				else{
					System.out.println("Bye Bye");
				}
			}
			
		}
		
	}
	
	/**
	 * This function just copies the function above 
	 */
	public void ContinueGame(){
		this.ocean = new Ocean();
		this.ocean.placeAllShipsRandomly();
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		while(this.ocean.isGameOver() == false){
			this.ocean.print();
			System.out.println("\nPlease enter the position you want to shoot the ship");
			String [] location = input.nextLine().split(",");
			
			if(location.length <= 1 || location.length > 2){
				System.out.println("invalid input");
				continue;
			}
			
			int row = Integer.parseInt(location[0]);
			int column = Integer.parseInt(location[1]);
			
			if( row > 9 || row <0 || column > 9 || column <0){
				System.out.println("invlaid input");
				continue;
			}
			
			this.ocean.shootAt(row, column);
			System.out.println("you have fired " + this.ocean.getShotsFired()+ "\n");
			System.out.println("you have sunk " + this.ocean.getShipsSunk()+ " ships" + "\n");
			if(this.ocean.isGameOver() == true){
				System.out.println("Congrats!!! You have sunk all the ships\n");
				System.out.println("Let's see how many shots you have fired\n");
				System.out.println("you have fired " + this.ocean.getShotsFired()+"\n");
				System.out.println("Do you wanna play a again  y/n \n");
				String continueGame =input2.nextLine();
				continueGame.toLowerCase();
				if(continueGame.equals("y")){
					this.ContinueGame();
				}
				else{
					System.out.println("Bye Bye");
				}
			}
			
		}
		
	}

}
