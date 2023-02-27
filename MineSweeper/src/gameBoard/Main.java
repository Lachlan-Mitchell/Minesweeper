package gameBoard;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Hello and welcome to MineSweeper! Please tell me how big the gird should be (nxn) as a value of n: ");
		int gameSize = s.nextInt();
		
		System.out.println("Awesome! Now tell me how many BOMBS we should have!");
		int bombs = s.nextInt();
		System.out.println("GoodLuck!\n\n");
		System.out.println("===========================\n\n\n");

		boolean[][] revealedArray = new boolean[gameSize][gameSize];
		GameBoard game1 = new GameBoard();
		CellSelection player = new CellSelection();
		

		int [][] theGame =  game1.setGameBoard(gameSize);
		
		
		System.out.println();
		System.out.println();
		
		int[][] currentGame =  (int[][]) HiddenGameArray.makeGame(theGame,bombs);
		
		
		game1.generateBoard(gameSize);
		
		//
		while(player.gameState /* and also needs a check if only bombs left, will need to set up a state which tracks if a cell has been selected */) {
			
			System.out.println();
			System.out.println("Choose an X coordinate");
			int x =  s.nextInt();
			System.out.println("Choose an Y coordinate");
			int y =  s.nextInt();
			
			RevelaedCells.revealedCells(x,y, revealedArray, theGame);
			game1.generateBoard(gameSize, currentGame, revealedArray);
			
			//func that takes in coords //func that checks if its a bomb //func that updates gameState
			player.cellSelect(x, y, currentGame);
			//func that redraws gameBoard
			player.gameStateCheck(revealedArray, bombs);
		}
		if(!player.gameState && player.hasWon) { 
			System.out.println("You won!");
		} else {
			System.out.println("You Lost!");
		}
     
		s.close();
	}

}
