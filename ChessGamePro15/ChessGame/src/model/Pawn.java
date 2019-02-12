package model;


/**
 * 
 * Defines the characteristics of the Pawn. 
 * 
 * @author Yardi
 *
 */
public class Pawn extends Pawns {
	private int forward;
	public Pawn(String color, int forward){
		super(color);
		this.forward = forward;
		}
	
	@Override
	public String toString() {
		
		return this.getcolor().equals("black") ? "p" : "P";
	}
	
	public int getForward(){
		return forward;
	}
}
