
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Play {

	boolean wumpusA = true;

	public static void main(String[] args) throws IOException{

		Scanner scan = new Scanner(System.in);


		SocketClient serve = new SocketClient();


		Controller controlGame = new Controller();
		Board board = new Board();
		// send data to the html page row and then col after semicolon
		serve.sendString("board:"+board.pieces.length+";"+controlGame.getRowAdventurer(board.pieces)+","+controlGame.getColAdventurer(board.pieces));

		while(!controlGame.gameHasFinished(board.pieces)){

			

			int rowB = controlGame.getRowAdventurer(board.pieces);
			int colB = controlGame.getColAdventurer(board.pieces);
			Adventurer ad  = (Adventurer) board.pieces[rowB][colB];
			serve.sendString(rowB+","+colB);

			System.out.println();

			System.out.println("You are currently at row : " + controlGame.getRowAdventurer(board.pieces) + " and col : " + controlGame.getColAdventurer(board.pieces));
			System.out.println("You have " + ad.arrows + " arrows");
			controlGame.getMessage(rowB, colB, board.pieces);
			System.out.println("You can move or shoot at the following rooms : ");

			controlGame.movesPossible(board.pieces);

			System.out.println("Move(m) or Shoot(s)");
			String moveShoot = scan.next();


			if(moveShoot.equals("m")){

				System.out.println("input row and column");
				System.out.println("Row : ");
				int rowE = scan.nextInt();
				System.out.println("Col : ");
				int colE = scan.nextInt();

				if(controlGame.moveIsLegal(controlGame.getRowAdventurer(board.pieces), controlGame.getColAdventurer(board.pieces), rowE, colE, board.pieces)){
					controlGame.move(rowB, colB, rowE, colE, board.pieces);
					ad.move(rowB, colB, rowE, colE, board.pieces);
				}
			}

			else if(moveShoot.equals("s")){

				System.out.println("input row and column");
				System.out.println("Row : ");
				int rowE = scan.nextInt();
				System.out.println("Col : ");
				int colE = scan.nextInt();

				if(controlGame.shotIsLegal(rowB, colB, rowE, colE, board.pieces)){

					controlGame.shoot(rowE, colE, ad.row, ad.col, board.pieces);
					

				}


			}


		}




	}

}
