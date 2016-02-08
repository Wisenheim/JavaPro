package model;

public class King extends Pawns {
	
	public King(String color){
		super(color);
	}

	@Override
	public String toString() {
		
		return this.getcolor().equals("black") ? "a" : "A";
	}
	
	
	
}
