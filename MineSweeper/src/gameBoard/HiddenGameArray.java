package gameBoard;


public class HiddenGameArray {
	
	// return an arr not a string -> this array will be used throughout as it has been populated
	
	public static int[][] makeGame(int[][] arr, int bombs){
		int initialBombs = bombs;
		if(bombs == 0) {
			System.out.println("Umm i guess you win? There are no bombs...");
			return arr;
		}
		
		if(bombs > arr.length * arr.length) {
			System.out.println("You cannot have more bombs than cells!");
			return arr;
		}
	
	while(bombs > 0) {
		int randomRow = (int) (Math.random() * arr.length);
		int randomCol = (int) (Math.random() * arr.length);
		if(arr[randomRow][randomCol] != -1) {
		arr[randomRow][randomCol]= -1;
		bombs--;
		}
	}
		
		for(int row = 0; row < arr.length; row++) {
		    for(int col =0; col < arr[0].length; col++) {
		        int bombsAdjacent = 0;
		        if(arr[row][col] == -1) {
		            continue;
		        } else {
		            // Set adjacent count to 0 for non-bomb cells
		            arr[row][col] = 0;

		            // Check adjacent cells for bombs -- applying Math, will stop us from getting out of bounds errors! - it also only loops the required section reducing iterations!
		            for(int i = Math.max(0, row - 1); i <= Math.min(arr.length - 1, row + 1); i++) {
		                for(int j = Math.max(0, col - 1); j <= Math.min(arr[0].length - 1, col + 1); j++) {
		                    if (arr[i][j] == -1) {
		                        bombsAdjacent++;
		                    }
		                }
		            }
		            // Set Cell value = how many bombs are adjacent
		            arr[row][col] = bombsAdjacent;
		        }
		    }
		}

	// representation of the 2d array
	for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
	}
	System.out.println("Game has been set up with " + initialBombs + " bombs.");
	return arr;
}
}
