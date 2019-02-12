package model;

/**
 * Abstract class of a chess Pawn
 * 
 * @author Yardi
 *
 */
public abstract class Pawns {
	private String color;
	private boolean havelife = true;
	
	public Pawns(String color){
		this.color = color;
	}
	
	public String getcolor(){
		return color;
	}

	public boolean IsAlive(){
		return havelife;
	}
	
	public abstract String toString();
	
}
