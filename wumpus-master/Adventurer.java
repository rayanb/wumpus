public class Adventurer extends Piece{
	int arrows = 10;
	
	public Adventurer(int row, int column){
		super.row = row;
		super.col = column;
	}


	public void move(){

	}
	
	

	
	
	
	
	
	public boolean moveIsLegal(int rowE, int colE, Piece[][] board){
		
		int rowB = this.row;
		int colB = this.col;
		
		int[][] possibleMoves = possibleMoves();
		
		for(int i = 0; i < possibleMoves.length; i++){
			
			int testRow = rowB + possibleMoves[i][0];
			int testCol = colB + possibleMoves[i][1];
			
			if(testRow >= 0 && testRow < board.length && testCol >= 0 && testCol < board.length && testCol == colE && testRow == colE){
				return true;
			}
			else{
				continue; 
			}
			
		}
		return false;
	}
	
	
	
	public int[][] possibleMoves(){
		
		int[][] possibleMoves = {{-1, 0},
								 {0, -1},
								 {1, 0},
								 {0, 1},
								 {0, 5},
								 {5, 0},
								 {-5, 0},
								 {0, -5}};
		
		
		return possibleMoves;
	}
	
	
	public void getMessage(Piece[][] board){
		
		boolean pitfall = false; // in order to display the pitfall message once
		
		
		int rowAdventurer = this.row;
		int colAdventurer = this.col;
		
		int[][] possibleMoves = possibleMoves();
		
		for(int i = 0; i < possibleMoves.length; i ++){
			
			int testRow = rowAdventurer + possibleMoves[i][0];
			int testCol = colAdventurer + possibleMoves[i][1];
			
			if(testRow >= 0 && testRow < possibleMoves.length && testCol >= 0 && testCol < possibleMoves.length){
				
				if(board[testRow][testCol] instanceof Wumpus){
					
					System.out.println("I can smell you");	
				}
				else if(board[testRow][testCol] instanceof Pitfall && !pitfall){
					System.out.println("I can feel the breeze");
					pitfall = true; 
					
				}
				else if(board[testRow][testCol] instanceof Treasure){
					System.out.println("Shiny Shiny glitteringness");
				}
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}