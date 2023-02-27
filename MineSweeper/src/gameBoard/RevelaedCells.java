package gameBoard;
// right now this only tracks the most recent cell...
public class RevelaedCells {
	public static boolean[][] revealedCells(int x, int y, boolean[][] revealedArray, int[][] gameArray){
	    revealedArray[y][x] = true;
	    if(gameArray[y][x] == 0) {
		    revealAdjacentCells(x, y, revealedArray, gameArray);
	    }
	    return revealedArray;
	}

	private static void revealAdjacentCells(int x, int y, boolean[][] revealedArray, int[][] gameArray) {
		//checks all adjacent tiles
	    for(int i = Math.max(0, y - 1); i <= Math.min(gameArray.length - 1, y + 1); i++) {
	        for(int j = Math.max(0, x - 1); j <= Math.min(gameArray[0].length - 1, x + 1); j++) {
	        	//reveal positive numbers (as bomb in 2d array is -1) that are adjacent, that haven't been revealed
	            if(gameArray[i][j] >= 0 && !revealedArray[i][j]) {
	                revealedArray[i][j] = true;
	                if (gameArray[i][j] == 0) {
	                    revealAdjacentCells(j, i, revealedArray, gameArray);
	                }
	            }
	        }
	    }
	}


}

