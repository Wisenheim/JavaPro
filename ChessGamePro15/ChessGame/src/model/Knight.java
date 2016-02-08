package model;

public class Knight extends Pawns{
	
	public Knight(String color){
		super(color);
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getcolor().equals("black") ? "k" : "K";
	}
	
	
}
