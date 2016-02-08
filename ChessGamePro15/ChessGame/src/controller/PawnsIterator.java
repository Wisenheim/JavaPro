package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Chessboard;
import model.Pawns;

public class PawnsIterator implements Iterator<Pawns> {
	private int currentIndex = 0;
	private ArrayList<Pawns> pawnsList = new ArrayList<Pawns>();
	private ArrayList<Integer> columnsList = new ArrayList<Integer>();
	private ArrayList<Integer> rowsList = new ArrayList<Integer>();
	
	public PawnsIterator(Chessboard board, String color){
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
					Pawns pawn = board.getPawn(i, j);
					if(pawn != null && pawn.getcolor().equals(color)){
						pawnsList.add(pawn);
						columnsList.add(j);
						rowsList.add(i);
					}
			}

	}
	
	
	@Override
	public boolean hasNext() {
		return currentIndex < pawnsList.size();
	}

	@Override
	public Pawns next() {
		return pawnsList.get(currentIndex++);
	}
	
	public int getX(){
		return rowsList.get(currentIndex - 1);		
	}
	
	public int getY(){
		return columnsList.get(currentIndex - 1);		
	}

}
