import java.util.Random;

public class Adventurer extends Piece{
	
	int arrows = 3;
	boolean isAlive = true;
	boolean hasTreasure = false;
	boolean hasExit = false;
	
	public Adventurer(int row, int column){
		super.row = row;
		super.col = column;
	}

	public void move(int rowB, int colB, int rowE, int colE, Piece[][] board){
		
		this.row = rowE;
		this.col = colE; 
		
		board[rowE][colE] = this;
		board[rowB][colB] = null;
	}
		
	public void shoot(int row, int col, Piece[][] board){
		
		this.arrows -= 1;
		
	}
	
	public void regenerate(Piece[][] board){
		
		int sizeOfBoard = board.length;
		
		Random random = new Random();
		
		int column = random.nextInt(sizeOfBoard);
		int row = random.nextInt(sizeOfBoard);
		
		if(board[row][column] == null){
			
			board[this.row][this.col] = null;
			
			this.row = row;
			this.col = column;
			
			board[this.row][this.col] = this;	
		}
		
		else{
			regenerate(board);
		}
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}