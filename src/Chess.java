/*
 * Name:
 * Section Leader:
 * File: Chess.java
 * ------------------
 * This program plays the game Chess.
 */

import java.awt.Color;
import java.awt.event.*;

/** The main class responsible for managing the chess game */
public class Chess extends GraphicsProgram{

	/** Object responsible for handling the graphical display on the screen */
	ChessDisplay display;
	
	/** Object that keeps track of the locations of all pieces */
	ChessBoard board;
	ChessFrame frame;
	ChessPiece lastPieceClicked;
	boolean isWhite;
	boolean isBlack;
	boolean isPiece;


	/** Method called before run responsible for initializing the ChessDisplay and 
	 *  ChessBoard objects */
	public void init()
	{
		//frame = new ChessFrame(this);
		//frame.init();
		display = ChessDisplay.getInstance(this);			// This line is required, don't change it
		board = new ChessBoard();

		display.useRealChessLabels(false);			// Use this method to change how the board is labeled
															// on the screen. Passing in true will label the board
		//display.selectSquare(0, 0, Color.GREEN);
		//display.draw(board);
		System.out.println("It is White's Turn");
		lastPieceClicked=null;													// like an official chessboard; passing in false will
															// label the board like it is indexed in an array and
															// in ChessDisplay.
		initBooleans();
	}
	
	/** The main method that runs the program */
	public void run()
	{
		// You fill this in.
		display.draw(board);

	}

	public boolean mouseListenersAdded(){
		//addMouseListener();
		return true;
	}


	public void initBooleans(){
		isWhite = true;
		isBlack = false;

	}

	public void mousePressed(MouseEvent m){
		int[] location = display.getLocation(m.getX(), m.getY()); //get
		System.out.println("Piece location is at X:"+location[0]+" Y:"+location[1]); // the first click
		if(!isPiece){
			if(board.pieceAt(location[0], location[1]).getColor()==ChessPiece.WHITE){ //if white clicked white piece
				if(isWhite){
					display.selectSquare(location[0], location[1], Color.GREEN); // display green as selected square
					lastPieceClicked = board.pieceAt(location[0], location[1]);
					display.draw(board);
					isPiece=true;
				} else {
					println("It is Black's Turn! Don't click White");
				}

			} else if (board.pieceAt(location[0], location[1]).getColor()==ChessPiece.BLACK){
				if(isBlack){
					display.selectSquare(location[0], location[1], Color.GREEN); // display green as selected square
					lastPieceClicked = board.pieceAt(location[0], location[1]);
					display.draw(board);
					isPiece=true;
				} else {
					println("It is White's Turn! Don't click Black");
				}
			}
		}else {
			if(lastPieceClicked.canMoveTo(location[0],location[1],board)){
				board.removePiece(lastPieceClicked.getRow(),lastPieceClicked.getCol());
				lastPieceClicked.moveTo(location[0], location[1]);
				board.addPiece(lastPieceClicked);
				display.unselectAll();
				display.draw(board);
				if (isInCheck(board,ChessPiece.BLACK)){
					if (isInCheckMate(board,ChessPiece.BLACK)){
						println("BLACK IS CHECKMATE!!");
						println("Mr. White Wins!!");
						isWhite=false;
						isBlack=false;
						isPiece=false;
					} else if (isInCheckMate(board,ChessPiece.BLACK)){
						println("STALEMATE!!!");
						isWhite=false;
						isBlack=false;
						isPiece=false;
					} else {
						println("Black's King is check!!");
						isWhite=false;
						isBlack=true;
						isPiece=false;
						System.out.println("It is Black's Turn!");
					}
				} else if (isInCheck(board,ChessPiece.WHITE)) {
					if (isInCheckMate(board, ChessPiece.WHITE)) {
						println("WHITE IS CHECKMATE!!");
						println("Mr. Black Wins!!");
						isWhite = false;
						isBlack = false;
						isPiece = false;
					} else if (isInCheckMate(board, ChessPiece.WHITE)) {
						println("STALEMATE!!!");
						isWhite = false;
						isBlack = false;
						isPiece = false;
					} else {
						println("White's King is check!!");
						isWhite = true;
						isBlack = false;
						isPiece = false;
						System.out.println("It is White's Turn!");
					}
				} else { //NORMAL
					if (isWhite){
						isWhite=false;
						isBlack=true;
						//isPiece=true;
						System.out.println("It is Black's Turn!");
					} else if (isBlack){
						isWhite=true;
						isBlack=false;
						//isPiece=true;
						System.out.println("It is White's Turn!");
					}
					isPiece=false;
				}
				lastPieceClicked=null;
			} else {
				if (isWhite){
					display.unselectAll();
					isWhite=true;
					isBlack=false;
					isPiece=false;
					System.out.println("It is Black's Turn!");
				} else if (isBlack){
					display.unselectAll();
					isWhite=false;
					isBlack=true;
					isPiece=false;
					System.out.println("It is White's Turn!");
				}
			}
		}
	}
}

