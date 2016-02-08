package controller;

import model.Chessboard;

public class MediumKingMoves extends BasicKingMoves {

	public MediumKingMoves(int x, int y, Chessboard board) {
		super(x, y, board);
	}
	
	@Override
	public boolean isValid(Move move, Chessboard board){
		if(!super.isValid(move, board))
				return false;
		if(move.isDestEmpty(board))
				return true;
		if(move.isOppenent(board))
				return true;
		return false;
	}
}
