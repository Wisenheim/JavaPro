package controller;

import model.Bishop;
import model.Chessboard;
import model.King;
import model.Knight;
import model.Pawn;
import model.Pawns;
import model.Queen;
import model.Rook;

public class MediumMovesGenerator {
	private final Move[] moves;
	public MediumMovesGenerator(int x, int y, Chessboard board){
		moves = calculateMoves(x, y, board);
	}
	
	protected Move[] calculateMoves(int x, int y, Chessboard board){
		Pawns pawn = board.getPawn(x, y);
		if(pawn == null)
				return new Move[0];
		if(pawn instanceof Pawn)
				return new MediumPawnMoves(x,y,board).getMoves();
		if(pawn instanceof Rook)
				return new MediumRookMoves(x,y,board).getMoves();
		if(pawn instanceof Bishop)
				return new MediumBishopMoves(x,y,board).getMoves();
		if(pawn instanceof Queen)
				return new MediumQueenMoves(x,y,board).getMoves();
		if(pawn instanceof Knight)
				return new MediumKnightMoves(x,y,board).getMoves();
		if(pawn instanceof King)
				return new MediumKingMoves(x,y,board).getMoves();
		return null;
		
	}
	
	public Move[] getMoves(){
		return moves;
	}
	
}

