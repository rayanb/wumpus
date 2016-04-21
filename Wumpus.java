
import java.util.Collections;
import java.util.Random;

public class Wumpus extends Piece{

	public boolean isAlive = true;

	public Wumpus(int row, int column){
		super.row = row;
		super.col = column;

	}

	public void move(Piece[][] board){
		
		Random ran = new Random();
		boolean madeMove = false;
		int length = board.length - 1;

		int[][] possibleMoves = {{-1, 0},
				{0, -1},
				{1, 0},
				{0, 1},
				{0, length},
				{length, 0},
				{-length, 0},
				{0, -length}};

		

		for (int i = ran.nextInt(possibleMoves.length); i < possibleMoves.length; i++) {
			

			int testRow = this.row + possibleMoves[i][0];   //takes a random valid position row from the possible moves
			int testCol = this.col + possibleMoves[i][1];   // takes a random valid position col from the possible moves

			if (testRow >= 0 && testRow < board.length && testCol >= 0 && testCol < board.length && (board[testRow][testCol] == null ||
					board[testRow][testCol] instanceof Pitfall) && ((testCol + testRow) - (this.row + this.col) == 1 ||
					(testCol + testRow) - (this.row + this.col) == -1)) { // makes the move
				
				board[this.row][this.col] = null;
				this.row = testRow;
				this.col = testCol;
				board[this.row][this.col] = this;
				madeMove = true;

			} else {
				continue;
			}
		}
		
		if(!madeMove){
			move(board);
		}

	}
}
