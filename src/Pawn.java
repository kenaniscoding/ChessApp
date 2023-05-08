/*
 * Name:
 * Section Leader:
 * File: Pawn.java
 * ------------------
 * This class represents the Pawn type of chess piece. This piece can move only straight 
 * forward (away from your side toward the other side). In can normally move only one space
 * at a time, except on the first move, when it has the option of moving two spaces. The pawn,
 * although it moves only forward, captures only diagonally forward. Turns out, this makes it
 * the most difficult to implement in code (fair warning). For more information go 
 * here: http://en.wikipedia.org/wiki/Pawn_(chess)
 */

public class Pawn extends ChessPiece{

	/** Constructor for the Pawn class */
	boolean firstMove;
	public Pawn(int initialRow, int initialCol, int pieceColor) //boolean firstMove
	{
		this.row = initialRow;
		this.col = initialCol;
		this.color = pieceColor;
		this.firstMove= true;
	}	

	/** Method that returns a boolean indicating whether or not the pawn can legally move
	 *  to the specified location (you need to fill this one in).
	 */
	public boolean canMoveTo(int nextRow, int nextCol, ChessBoard board)
	{
		boolean canMove = false;
		if (this.color==WHITE){
			if (this.firstMove){
				if((this.row - nextRow == 1) && (this.col ==nextCol)){
					if (board.pieceAt(nextRow, nextCol)==null){
						canMove =!moveWouldCauseCheck(nextRow, nextCol, board);;
						firstMove=false;
					}
				} else if ((this.row - nextRow ==2) && (this.col ==nextCol)) {
					if (board.pieceAt(nextRow+1, nextCol)==null){
						//System.out.println("hello");
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
						firstMove=false;
					}
				} else if (nextRow-this.row==-1 && nextCol-this.col==-1){
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
						firstMove=false;
					}
				} else if (nextRow-this.row==-1 && nextCol-this.col==1){
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
						firstMove=false;
					}
				}
			} else {
				if ((this.row -nextRow ==1) && (this.col ==nextCol)){
					if (board.pieceAt(nextRow,nextCol)==null){
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
					}
				} else if (nextRow-this.row==-1 && nextCol-this.col==-1){
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
					}
				} else if (nextRow-this.row==-1 && nextCol-this.col==1){
					if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.BLACK){
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
					}
				}
			}
		} else {
			if (this.firstMove){
				if((this.row - nextRow == -1) && (this.col ==nextCol)){
					if (board.pieceAt(nextRow, nextCol)==null){
						canMove =!moveWouldCauseCheck(nextRow, nextCol, board);;
						firstMove=false;
					}
				}else if ((this.row - nextRow ==-2) && (this.col ==nextCol)) {
					if (board.pieceAt(nextRow-1, nextCol)==null){
						//System.out.println("hello2");
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
						firstMove=false;
					}
				} else {
					canMove = isCanMove(nextRow, nextCol, board, canMove);
				}
			} else {
				if ((this.row -nextRow ==-1) && (this.col ==nextCol)){
					if (board.pieceAt(nextRow,nextCol)==null){
						canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
					}
				}else {
					canMove = isCanMove(nextRow, nextCol, board, canMove);
				}
			}
		}
		return canMove;
	}

	private boolean isCanMove(int nextRow, int nextCol, ChessBoard board, boolean canMove) {
		if (nextRow-this.row==1 && nextCol-this.col==-1){
			if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE){
				canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
			}
		} else if (nextRow-this.row==1 && nextCol-this.col==1){
			if(board.pieceAt(nextRow, nextCol).getColor() == ChessPiece.WHITE){
				//works
				canMove=!moveWouldCauseCheck(nextRow, nextCol, board);;
			}
		}
		return canMove;
	}

	/** Implementation of getType() method for the Pawn class. Provides a way to identify
	 *  the Pawn-type chess piece as such (you don't need to change anything here)
	 */
	public PieceType getType() 
	{
		return PieceType.PAWN;
	}
	
}
