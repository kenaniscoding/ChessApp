/*
 * Name:
 * Section Leader:
 * File: Knight.java
 * ------------------
 * This class represents the Knight type of chess piece. This piece can move only in 
 * L-shapes. That is it moves two spaces in one direction and one space in an orthogonal
 * direction. It is the only piece in chess that can jump over other pieces. For
 * more information go here: http://en.wikipedia.org/wiki/Knight_(chess)
 */

public class Knight extends ChessPiece{

	/** Constructor for the Knight class */
	public Knight(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}		
	
	/** Method that returns a boolean indicating whether or not the king can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		// Fill this in with your own code.
		boolean canMove=false;
		if(this.color==WHITE){
			if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				}
			}
		}else {
			if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE){
					canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
				}
			}
		}
		return canMove;
	}
	
	/** Implementation of getType() method for the Knight class. Provides a way to identify
	 *  the Knight-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.KNIGHT;
	}
	
}
