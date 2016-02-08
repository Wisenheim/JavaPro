package controller;

import java.util.ArrayList;

import model.Chessboard;
import model.Pawns;

public class AdvancedMovesGenerator extends MediumMovesGenerator {

	public AdvancedMovesGenerator(int x, int y, Chessboard board) {
		super(x, y, board);
	}
	
	@Override
	protected Move[] calculateMoves(int x, int y, Chessboard board){
		Move[] moves = super.calculateMoves(x, y, board);
		ArrayList<Move> validMoves = new ArrayList<Move>();
		
		for(Move move:moves)
			if(!makeMyKingUnderCheck(move,board))
				validMoves.add(move);
		
		return validMoves.toArray(new Move[validMoves.size()]);
	}
	
	//esegue la mossa su una copia della scacchiera e ritorna IsKingUnderCheck
	private boolean makeMyKingUnderCheck(Move move, Chessboard board){
		Chessboard boardCopy = new Chessboard(board);
		
		move.execute(boardCopy);
		
		return isMyKingChecked(move.getX(), move.getY(),boardCopy);
	}
	
	private boolean isMyKingChecked (int x, int y, Chessboard board){
			Pawns p = board.getPawn(x, y);
			return new IsKingUnderCheck(p.getcolor(), board).isCheck();
	}
}
