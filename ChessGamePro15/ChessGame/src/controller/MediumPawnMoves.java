package controller;

import model.Chessboard;


public class MediumPawnMoves extends BasicPawnMoves {

	public MediumPawnMoves(int x, int y, Chessboard board) {
		super(x, y, board);
	}
	
	@Override
	public boolean isValid(Move move, Chessboard board){
		if(!super.isValid(move, board))
				return false;
		if(move.isDestEmpty(board))
				return !move.isDiagonal();
		if(!move.isDiagonal())
				return false;
		return move.isOppenent(board);
	}
}
