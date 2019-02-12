package controller;

import model.Chessboard;

import model.Pawns;

/**
 * 
 * 
 * Simple class for the abstract Move in a chess board
 * 
 * 
 * @author Yardi
 *
 */
public class Move {
	private final int oldx,oldy,x,y;
	
	public Move(int oldx,int oldy, int newx, int newy){
		this.oldx = oldx;
		this.oldy = oldy;
		this.x = newx;
		this.y = newy;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getOldX(){
		return oldx;
	}
	
	public int getOldY(){
		return oldy;
	}
	
	/**
	 * 
	 * it modifies the board by moving a pawn from a position to another.
	 * 
	 * @param board
	 */
	public void execute(Chessboard board){
		Pawns p = board.getPawn(oldx, oldy);
		board.changePawnTo(x, y, p);
		board.removePawn(oldx, oldy);
	}
	
	/**
	 * 
	 * Returns true if a move is the same of another move, false otherwise.
	 * 
	 */
	@Override
	public boolean equals(Object other){
		if (!(other instanceof Move))
			return false;
		Move otherAsMove = (Move) other;
		return (this.oldx == otherAsMove.oldx) && (this.oldy == otherAsMove.oldy)
				&& (this.x == otherAsMove.x) && (this.y == otherAsMove.y);
	}
	
	
	/**
	 * 
	 * Returns the origin position and the destination position of a Move.
	 * 
	 */
	@Override
	public String toString(){
		return "( " + this.oldx + "," + this.oldy + " ) --> (" +
				 this.x + "," + this.y + " )";
	}
	
	
	/**
	 * Returns true if the current move is a diagonal one.
	 * 
	 * @return
	 */
	public boolean isDiagonal(){
		return this.getOldX() != this.getX() && this.getOldY() != this.getY();
	}
	
	
	/**
	 * given a board in input, it checks if the destination position is Empty.
	 * 
	 * @param board
	 * @return
	 */
	public boolean isDestEmpty(Chessboard board){
		
		return board.getPawn(this.getX(), this.getY()) == null;
	}
	
	
	/**
	 * Given a board in input, it checks if the destination position have an oppenent pawn.
	 * 
	 * @param board
	 * @return
	 */
	public boolean isOppenent(Chessboard board){
		Pawns p1 = board.getPawn(this.getOldX(), this.getOldY());
		Pawns p2 = board.getPawn(this.getX(), this.getY());
		if(p1 == null || p2 == null)
				return false;
		return !(p1.getcolor().equals(p2.getcolor()));
	}

}
