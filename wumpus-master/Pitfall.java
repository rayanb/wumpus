public class Pitfall extends Piece{
	public Pitfall(int row, int column){
		super.row = row;
		super.col = column;
	}

	public static void main(String[] Args){
		Pitfall pit = new Pitfall(1, 2);
		System.out.println(pit.row);
	}

	
}

