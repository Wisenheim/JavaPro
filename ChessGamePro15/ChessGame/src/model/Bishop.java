package model;


/**
 * 
 * 
 * @author Yardi
 *
 */
public class Bishop extends Pawns{
	
	public Bishop(String color){
		super(color);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getcolor().equals("black") ? "b" : "B";
	}
	
	
}
