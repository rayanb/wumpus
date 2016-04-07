import java.util.Random;

class Board{
	public Random r = new Random();
	public int size = r.nextInt(5) + 6;
	private int wump = 1;
	private int adventurer = 1;
	private int pitfalls = size/2;
	private int superbards = size/2;
	public Piece[][] pieces;




	public Board(){
		this.pieces = new Piece[size][size];
	}

	public static void main(String[] Args){
		Board board = new Board();
		board.setPieces();
	}

	public void setPieces(){
		pieces[2][4]

	}



	public void createAdventurer(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Adventurer();	
		}
		else{
			createAdventurer();
		}
	}

	public void createWumpus(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Wumpus();	
		}
		else{
			createWumpus();
		}
	}

	public void createPitfall(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Pitfall();	
		}
		else{
			createPitfall();
		}
	}

	public void createSuperbar(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Superbar();	
		}
		else{
			createSuperbar();
		}
	}


}
