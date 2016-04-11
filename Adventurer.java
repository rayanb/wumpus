public class Adventurer extends Piece{
	int arrows = 10;
	public Adventurer(int row, int column){
		super.row = row;
		super.column = column;
	}


	public void move(){

	}


	public static boolean checkMove(int row, int column){
		return true;
	}


}