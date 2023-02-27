package gameBoard;

public class CellSelection {
	boolean gameState = true;
	boolean hasWon = false;
	
	public CellSelection() {
		
	}
	public boolean gameStateCheck(boolean[][] revealedArray, int bombs) {
		int falseCount = 0;
		for (int i = 0; i < revealedArray.length; i++) {
		    for (int j = 0; j < revealedArray[i].length; j++) {
		        if (!revealedArray[i][j]) {
		            falseCount++;
		        }
		    }
		}
		if(falseCount == bombs) {
			gameState = false;
			hasWon = true;
			return false;
		}
		return true;
	}

	public boolean cellSelect(int x, int y, int [][] gameArray) {
		if(x > gameArray.length || x < 0 || y > gameArray.length || y < 0) {
			gameState = false;
			System.out.println("This coordinate is out of bounds, game closing");
			return false;
		}
		else if(gameArray[y][x] == -1) {
			gameState = false;
			return false;
		} else {
			return true;
		}
	}
}
