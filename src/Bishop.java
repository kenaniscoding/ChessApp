/*
 * Name:
 * Section Leader:
 * File: Bishop.java
 * ------------------
 * This class represents the Bishop type of chess piece. This piece can move and capture 
 * pieces along diagonals. For more information visit: http://en.wikipedia.org/wiki/Bishop_(chess)
 */

public class Bishop extends ChessPiece{

	/** Constructor for the Bishop class */
	public Bishop(int initialRow, int initialCol, int pieceColor)
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
		if(this.color==WHITE){
			if(Math.abs(nextRow-this.row)!=Math.abs(nextCol-this.col)){
				canMove=false;
			} else if(board.pieceAt(nextRow,nextCol)!=null){
				if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE ){
					canMove=false;
				}
			}else{
				canMove=checkIfBlocked(nextRow,nextCol,board);
			}

		}else{
			if(Math.abs(nextRow-this.row)!=Math.abs(nextCol-this.col)){
				canMove=false;
			} else if(board.pieceAt(nextRow,nextCol)!=null){
				if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK ){
					canMove=false;
				}
			}else{
				canMove=checkIfBlocked(nextRow,nextCol,board);
			}
		}
		return canMove;
		//return automagicBishopCanMoveTo(nextRow, nextCol, board);	// Eventually this line should not be here
	}
	public boolean checkIfBlocked(int nextRow, int nextCol, ChessBoard board){
		boolean canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
		int dx=this.row-nextRow;
		int dy=this.col-nextCol;
		int spaces=Math.abs(this.row-nextRow);
		if (dx>0 && dy<0) {//1st quadrant
			System.out.println("1st Space="+spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row-i,this.col+i)!=null){
					canMove=false;
				}
			}
		}else if(dx<0 && dy<0){ //2nd quadrant
			System.out.println(spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row+i,this.col+i)!=null){
					canMove=false;
				}
			}
		}else if (dx<0 && dy>0){// 3rd quadrant
			System.out.println("3rd Space="+spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row+i,this.col-i)!=null){
					canMove=false;
				}
			}
		} else if (dx>0 && dy>0){//4th quadrant
			System.out.println(spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row-i,this.col-i)!=null){
					canMove=false;
				}
			}
		}
		return canMove;
	}

	
	/** Implementation of getType() method for the Bishop class. Provides a way to identify
	 *  the Bishop-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.BISHOP;
	}
}
