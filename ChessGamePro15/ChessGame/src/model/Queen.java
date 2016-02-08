package model;

public class Queen extends Pawns {
	
	public Queen(String color){
		super(color);

	}

	@Override
	public String toString() {
		
		return this.getcolor().equals("black") ? "q" : "Q";
	}
}
