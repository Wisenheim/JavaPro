package controller;

import model.Chessboard;

import model.Pawns;


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
	
	//modifica la scacchiera
	public void execute(Chessboard board){
		Pawns p = board.getPawn(oldx, oldy);
		board.changePawnTo(x, y, p);
		board.removePawn(oldx, oldy);
	}
	
	//ritorna vero se oldx, oldy , x e y sono uguale a le oldx, oldy, x e y dell'altra mossa
	@Override
	public boolean equals(Object other){
		if (!(other instanceof Move))
			return false;
		Move otherAsMove = (Move) other;
		return (this.oldx == otherAsMove.oldx) && (this.oldy == otherAsMove.oldy)
				&& (this.x == otherAsMove.x) && (this.y == otherAsMove.y);
	}
	
	//ritorna la prima posizione e la posizione finale 
	@Override
	public String toString(){
		return "( " + this.oldx + "," + this.oldy + " ) --> (" +
				 this.x + "," + this.y + " )";
	}
	
	//torna True se la mossa corrente è diagonale
	public boolean isDiagonal(){
		return this.getOldX() != this.getX() && this.getOldY() != this.getY();
	}
	
	
	public boolean isDestEmpty(Chessboard board){
		
		return board.getPawn(this.getX(), this.getY()) == null;
	}
	
	public boolean isOppenent(Chessboard board){
		Pawns p1 = board.getPawn(this.getOldX(), this.getOldY());
		Pawns p2 = board.getPawn(this.getX(), this.getY());
		if(p1 == null || p2 == null)
				return false;
		return !(p1.getcolor().equals(p2.getcolor()));
	}

}
