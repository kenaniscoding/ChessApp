/*
 * Name:
 * Section Leader:
 * File: Rook.java
 * ------------------
 * This class represents the Rook type of chess piece. This piece can move and capture 
 * pieces along rows and columns. It is also known as a castle. For more information visit: 
 * http://en.wikipedia.org/wiki/Rook_(chess)
 */

import java.sql.SQLOutput;

public class Rook extends ChessPiece{

	/** Constructor for the Rook class */
	public Rook(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	

	/** Method that returns a boolean indicating whether or not the bishop can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		// Fill this in with your own code.
		boolean canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
		if (this.color==WHITE){
			if(this.row!=nextRow && this.col!=nextCol){
				canMove=false;
			} else if(board.pieceAt(nextRow,nextCol)!=null){
				if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE ){
					canMove=false;
				}
			}else{
				canMove=checkIfBlocked(nextRow,nextCol,board);
			}
		}else{
			if(this.row!=nextRow && this.col!=nextCol){
				canMove=false;
			}else if(board.pieceAt(nextRow,nextCol)!=null){
				if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK ){
					canMove=false;
				}
			}else{
				canMove=checkIfBlocked(nextRow,nextCol,board);
			}
		}
		return canMove;
	}
	public boolean checkIfBlocked(int nextRow, int nextCol, ChessBoard board){
		boolean canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
		if(nextRow>this.row){
			int spaces=Math.abs(nextRow-this.row);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row+i, this.col)!=null){
					canMove=false;
				}
			}
		}else if (nextRow<this.row){
			int spaces=Math.abs(nextRow-this.row);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row-i, this.col)!=null){
					canMove=false;
				}
			}
		}else if (nextCol>this.col){
			int spaces=Math.abs(nextCol-this.col);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row, this.col+i)!=null){
					canMove=false;
				}
			}
		}else if (nextCol<this.col){
			int spaces=Math.abs(nextCol-this.col);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row, this.col-i)!=null){
					canMove=false;
				}
			}
		}
		return canMove;
	}
	/** Implementation of getType() method for the Rook class. Provides a way to identify
	 *  the Rook-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.ROOK;
	}

}
