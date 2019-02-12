package model;


/**
 * Defines all the characteristics of the Queen pawn, as much as <b>Freddie Mercurry</b> had.
 * 
 * @author Yardi
 *
 */
public class Queen extends Pawns {
	
	public Queen(String color){
		super(color);

	}

	@Override
	public String toString() {
		
		return this.getcolor().equals("black") ? "q" : "Q";
	}
}
