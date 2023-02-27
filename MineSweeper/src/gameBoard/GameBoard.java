package gameBoard;

public class GameBoard {
	public int[][] setGameBoard(int gameSize){
		int[][] gameArray = new int[gameSize][gameSize];
		
		return gameArray;
	}
	
	public void generateBoard(int gameSize) {
		for (int rowNum = 0; rowNum < gameSize; rowNum++) {
			//make 10 +--- in a row (representing the 10 cols)
			  for (int col = 0; col < gameSize; col++) {
			    System.out.print("+---");
			  }
			  //For the end of each row, also using println will make the "pipes" appear on the line below
			  System.out.println("+");
			  for (int colWall = 0; colWall < gameSize; colWall++) {
				  //left + right walls of a box (technically all left walls)
			    System.out.print("|   ");
			  }
			  // final pipe for the end of the grid, followed by what iteration loop we are on. 
			  System.out.println("| " + rowNum); 
			}
			for (int baseCol = 0; baseCol < gameSize; baseCol++) {
			  System.out.print("+---");
			}
			System.out.println("+");
			for (int colNum = 0; colNum < gameSize; colNum++) {
			  System.out.print("  " + colNum + " "); 
			}
	} 
	
	
	public void generateBoard(int gameSize, int[][] gameBoardState, boolean[][] revealedState) {
	    for (int rowNum = 0; rowNum < gameSize; rowNum++) {
	        // make 10 +--- in a row (representing the 10 cols)
	        for (int col = 0; col < gameSize; col++) {
	            System.out.print("+---");
	        }
	        // For the end of each row, also using println will make the "pipes" appear on the line below
	        System.out.println("+");
	        for (int colWall = 0; colWall < gameSize; colWall++) {
	            // left + right walls of a box (technically all left walls)
	            int cellValue = gameBoardState[rowNum][colWall];
	            boolean cellState = revealedState[rowNum][colWall];
	            if (cellValue == -1 && cellState == true) {
	                // If the cell contains a bomb, show the bomb symbol
	                System.out.print("| X ");
	            } else if (cellState == true) {
	                // If the cell is empty, show a blank space
	                System.out.print("| " + cellValue + " "); 
	            } else {
	                // If the cell contains a number, show the number
	                System.out.print("|   ");
	            }
	        }
	        // final pipe for the end of the grid, followed by what iteration loop we are on.
	        System.out.println("| " + rowNum);
	    }
	    for (int baseCol = 0; baseCol < gameSize; baseCol++) {
	        System.out.print("+---");
	    }
	    System.out.println("+");
	    for (int colNum = 0; colNum < gameSize; colNum++) {
	        System.out.print("  " + colNum + " ");
	    }
	}
	
}
