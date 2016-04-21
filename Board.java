
import java.util.Random;

class Board{
	public Random r = new Random();
	public int size = r.nextInt(5) + 6;
	private int wump = 1;
	private int adventurer = 1;
	private int pitfalls = size/2;
	private int superbats = size/2;
	private int exit = 1;
	private int treasure = 1;
	public Piece[][] pieces;




	public Board(){
		this.pieces = new Piece[size][size];
		for(int i =0; i< superbats;i++){
			createSuperbat();
			createPitfall();
		}
		createAdventurer();
		createWumpus();
		createExit();
		createTreasure();
		/*
		int i = 0;
		for(Piece[] pieces:this.pieces){
			System.out.println("-----");
			for(Piece piece : pieces){

				System.out.print("| "+piece+" |");
				if(piece != null){
				  
				}
				i++;
			}
			System.out.println("----");
		}
		System.out.println("count:"+i);
	}
	*/
	}
/*
	public static void main(String[] Args){
		Board board = new Board();
		
		
		System.out.println(board.size);
		
		
		
		
	}
*/
	public int getRowAdventurer(){
		
		int row = 0;
		
		for(int i = 0; i < this.pieces.length; i++){
			for(int j = 0; j < this.pieces.length; j++){
				if(this.pieces[i][j] instanceof Adventurer){
					row = i; 
				}
			}
		}
		
		return row;
		
	}
	
	public int getColAdventurer(){
		
		int col = 0;
		
		for(int i = 0; i < this.pieces.length; i++){
			for(int j = 0; j < this.pieces.length; j++){
				if(this.pieces[i][j] instanceof Adventurer){
					col = j; 
				}
			}
		}
		
		return col;
		
	}

	public void createAdventurer(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Adventurer(x, y);	
		}
		else{
			createAdventurer();
		}
	}

	public void createWumpus(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Wumpus(x, y);	
		}
		else{
			createWumpus();
		}
	}

	public void createPitfall(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Pitfall(x, y);	
		}
		else{
			createPitfall();
		}
	}

	public void createSuperbat(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Superbat(x, y);	
		}
		else{
			createSuperbat();
		}
	}

	public void createExit(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Exit(x, y);	
		}
		else{
			createExit();
		}
	}

	public void createTreasure(){
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		if(this.pieces[x][y] == null){
		    this.pieces[x][y] = new Treasure(x, y);	
		}
		else{
			createTreasure();
		}
	}
	public void showBoard(){
		int i = 0;
		for(Piece[] pieces:this.pieces){
			System.out.println("-----");
			for(Piece piece : pieces){

				System.out.print("| "+piece+" |");
				if(piece != null){
				  
				}
				i++;
			}
			System.out.println("----");
		}
		System.out.println("count:"+i);
	}

}
