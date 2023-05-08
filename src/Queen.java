/*
 * Name:
 * Section Leader:
 * File: Queen.java
 * ------------------
 * This class represents the Queen type of chess piece. This piece can move and capture
 * in any straight line (diagonally, horizontally, or vertically). For more information go 
 * here: http://en.wikipedia.org/wiki/Queen_(chess)
 */

public class Queen extends ChessPiece{

	/** Constructor for the Queen class */
	public Queen(int initialRow, int initialCol, int pieceColor)
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
	}	
	
	/** Method that returns a boolean indicating whether or not the queen can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		// Fill this in with your own code.
		boolean canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
		if(this.color==WHITE){
			if (board.pieceAt(nextRow,nextCol)!=null) {
				if (Math.abs(nextRow-this.row)==Math.abs(nextCol-this.col)){ //bishop check
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE ){
						canMove=false;
					} else {
						canMove=checkIfBlocked(nextRow,nextCol,board);
					}
				} else if (this.row==nextRow || this.col==nextCol){ //rook check
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE ){
						canMove=false;
					} else {
						canMove=checkIfBlocked(nextRow,nextCol,board);
					}
				} else {
					System.out.println("error");
					canMove=false;
				}
			} else { // board piece click is black
				if (Math.abs(nextRow-this.row)==Math.abs(nextCol-this.col)){ //bishop check
					canMove=checkIfBlocked(nextRow,nextCol,board);
				} else if (this.row==nextRow || this.col==nextCol){ //rook check
					canMove=checkIfBlocked(nextRow,nextCol,board);
				} else {
					System.out.println("error");
					canMove=false;
				}
			}
		} else{ //BLACK
			if (board.pieceAt(nextRow,nextCol)!=null) {
				if (Math.abs(nextRow-this.row)==Math.abs(nextCol-this.col)){ //bishop check
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK ){
						canMove=false;
					} else {
						canMove=checkIfBlocked(nextRow,nextCol,board);
					}
				} else if (this.row==nextRow || this.col==nextCol){ //rook check
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK ){
						canMove=false;
					} else {
						canMove=checkIfBlocked(nextRow,nextCol,board);
					}
				} else {
					System.out.println("error");
					canMove=false;
				}
			} else { // board piece click is white
				if (Math.abs(nextRow-this.row)==Math.abs(nextCol-this.col)){ //bishop check
					System.out.println("3");
					canMove=checkIfBlocked(nextRow,nextCol,board);
				} else if (this.row==nextRow || this.col==nextCol){ //rook check
					System.out.println("4");
					canMove=checkIfBlocked(nextRow,nextCol,board);
				} else {
					System.out.println("error");
					canMove=false;
				}
			}
		}
		return canMove;
		//return automagicQueenCanMoveTo(nextRow, nextCol, board);	// Eventually this line should not be here
	}
	public boolean checkIfBlocked(int nextRow, int nextCol, ChessBoard board){
		boolean canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
		int dx=this.row-nextRow;
		int dy=this.col-nextCol;
		if (dx>0 && dy<0) {
			int spaces=Math.abs(this.row-nextRow);
			System.out.println("1st Space="+spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row-i,this.col+i)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		}else if(dx<0 && dy<0){
			int spaces=Math.abs(this.row-nextRow);
			System.out.println(spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row+i,this.col+i)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		}else if (dx<0 && dy>0){
			int spaces=Math.abs(this.row-nextRow);
			System.out.println("3rd Space="+spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row+i,this.col-i)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		} else if (dx>0 && dy>0){
			int spaces=Math.abs(this.row-nextRow);
			System.out.println(spaces);
			for (int i=1;i<spaces;i++){
				if(board.pieceAt(this.row-i,this.col-i)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		} else if(nextRow>this.row){
			int spaces=Math.abs(nextRow-this.row);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row+i, this.col)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		}else if (nextRow<this.row){
			int spaces=Math.abs(nextRow-this.row);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row-i, this.col)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		}else if (nextCol>this.col){
			int spaces=Math.abs(nextCol-this.col);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row, this.col+i)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		}else if (nextCol<this.col){
			int spaces=Math.abs(nextCol-this.col);
			for(int i=1; i<spaces;i++){
				if(board.pieceAt(this.row, this.col-i)!=null){
					canMove=false;
				}
			} if((Math.abs(nextRow-this.row)==1)&&(Math.abs(nextCol-this.col)==2)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			} else if ((Math.abs(nextRow-this.row)==2)&&(Math.abs(nextCol-this.col)==1)){
				if (board.pieceAt(nextRow,nextCol)==null){
					canMove=false;
				} else if (board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
					canMove=false;
				}
			}
		}
		return canMove;
	}
	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.QUEEN;
	}
	
}
