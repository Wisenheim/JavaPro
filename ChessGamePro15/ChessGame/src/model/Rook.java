package model;

public class Rook extends Pawns{
	
	public Rook(String color){
		super(color);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getcolor().equals("black") ? "r" : "R";
	}
	
	
}
