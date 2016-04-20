import java.util.Random;

public class Controller {

	// this class will handle all the rules ;

	// checks whether a move is legal or not

	public boolean moveIsLegal(int rowB, int colB, int rowE, int colE, Piece[][] board) {


		if (board[rowB][colB] instanceof Wumpus || board[rowB][colB] instanceof Adventurer) {


			int[][] possibleMoves = possibleMoves();

			for (int i = 0; i < possibleMoves.length; i++) {

				// takes every single pair from the 2d array and tests it
				
				int testRow = rowB + possibleMoves[i][0];    
				int testCol = colB + possibleMoves[i][1];

				if (testRow >= 0 && testRow < board.length && testCol >= 0 && testCol < board.length && testCol == colE && testRow == colE) {
					return true;
				} else {
					continue;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	// return an 2d array with all posible moves by calculating the distance between a particular cell
	public int[][] possibleMoves() {

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


	// gets an appropriate message if something is near the adventurer
	public void getMessage(int rowAdventurer, int colAdventurer, Piece[][] board) {  // can change it and delete rowA and colA and use the getrow methods

		boolean pitfall = false; // in order to display the pitfall message once

		int[][] possibleMoves = possibleMoves(); // create an array with all the possible moves

		for (int i = 0; i < possibleMoves.length; i++) {

			int testRow = rowAdventurer + possibleMoves[i][0];
			int testCol = colAdventurer + possibleMoves[i][1];

			if (testRow >= 0 && testRow < possibleMoves.length && testCol >= 0 && testCol < possibleMoves.length) {

				if (board[testRow][testCol] instanceof Wumpus) {

					System.out.println("I can smell you");
				} else if (board[testRow][testCol] instanceof Pitfall && !pitfall) {
					System.out.println("I can feel the breeze");
					pitfall = true;

				} else if (board[testRow][testCol] instanceof Treasure) {
					System.out.println("Shiny Shiny glitteringness");
				}
				else{
					continue;
				}

			}
		}

	}

	// check whether the adventurer can shoot 
	public boolean shotIsLegal(int rowAdventurer, int columnAdventurer, int rowShoot, int colShoot, Piece[][] board) {


		if (moveIsLegal(rowAdventurer, columnAdventurer, rowShoot, colShoot, board)) {  // check whether the point of shooting is into an adjastent cell
			if (((Adventurer) board[rowAdventurer][columnAdventurer]).arrows > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;

		}

	}

	// makee movee depending on the position of the adventurer
	public void move(int rowB, int colB, int rowE, int colE, Piece[][] board) {

		if (moveIsLegal(rowB, colB, rowE, colE, board)) {  // check that the move is legal (may delete that afterwards0

			Adventurer adv = (Adventurer) board[rowB][colB];

			if (board[rowE][colE] == null) {
				adv.move(rowB, colB, rowE, colE, board);
			} else if (board[rowE][colE] instanceof Superbat) {
				System.out.println("You have reached a super bat and you are moved to a new position ");
				adv.regenerate(board);
			} else if (board[rowE][colE] instanceof Pitfall) {
				System.out.println("You have fallen to a pitfall");
				adv.isAlive = false;
			} else if (board[rowE][colE] instanceof Treasure) {
				System.out.println("You have found the treasure");
				adv.hasTreasure = true;
			} else if (board[rowE][colE] instanceof Wumpus) {
				System.out.println("The wumpus killed you");
				adv.isAlive = false;
			}
			else if(board[rowE][colE] instanceof Exit){
				if(adv.hasTreasure){
					System.out.println("You have won the game");
					adv.hasExit = true;
				}
				else{
					System.out.println("You have exited the game without collecting the treasure");
					adv.hasExit = true;
				}
			}

		} else {
			System.out.println("The move you are trying to make is illegal");
		}


	}

	public void shoot(int rowShoot, int colShoot, int rowAventurer, int colAdventurer, Piece[][] board) {


		if(shotIsLegal(rowAventurer,colAdventurer,rowShoot,colShoot, board)){

			Adventurer adv = (Adventurer) board[rowAventurer][colAdventurer];
			adv.shoot(rowShoot, colShoot, board);

			if(board[rowShoot][colShoot] instanceof Wumpus){

				System.out.println("You have killed the wumpus ");
				Wumpus wumpus = (Wumpus) board[rowShoot][colShoot];
				wumpus.isAlive = false;

			}
			else{
				System.out.println("You have missed and the wumpus has moved");
				Wumpus wump = (Wumpus) board[getRowWumpus(board)][getColAdventurer(board)];
				wump.move(board); 
			}
		}
	}
	
	public boolean gameHasFinished(Piece[][] board){
		Adventurer adventurer = (Adventurer) board[getRowAdventurer(board)][getColAdventurer(board)];
		
		if(!adventurer.isAlive || adventurer.hasExit){
			return true; 
		}
		else{
			return false;
		}
		
	}

	public int getRowWumpus(Piece[][] board) {

		int row = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] != null && board[i][j] instanceof Wumpus) {
					row = i;
				}
			}
		}

		return row;
	}

	public int getColWumpus(Piece[][] board){

		int col = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] != null && board[i][j] instanceof Wumpus) {
					col = j;
				}
			}
		}
		return col;
	}

	public int getRowAdventurer(Piece[][] board){

		int row = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] != null && board[i][j] instanceof Adventurer) {
					row = i;
				}
			}
		}
		return row;
	}

	public int getColAdventurer(Piece[][] board){

		int col = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {

				if (board[i][j] != null && board[i][j] instanceof Adventurer) {
					col = j;
				}
			}
		}
		return col;

	}
}
